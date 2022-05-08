import SwiftUI
import shared

struct ContentView: View {
  @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        NavigationView {
            listView()
            .navigationBarTitle("微言码道")
            .navigationBarItems(trailing:
                Button("Reload") {
                    self.viewModel.loadBlogs(forceReload: true)
            })
        }
    }

    private func listView() -> AnyView {
        switch viewModel.status {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let launches):
            return AnyView(List(launches) { launch in
                BlogRow(blog: launch)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

extension ContentView {

    enum LoadableBlogs {
        case loading
        case result([BlogDTO])
        case error(String)
    }

    class ViewModel: ObservableObject {
        let sdk: BlogSDK
        @Published var status = LoadableBlogs.loading

        init(sdk: BlogSDK) {
            self.sdk = sdk
            self.loadBlogs(forceReload: false)
        }

        func loadBlogs(forceReload: Bool) {
            self.status = .loading
            sdk.getBlogs(forceReload: forceReload, completionHandler: { blogs, error in
                if let blogs = blogs {
                    self.status = .result(blogs)
                } else {
                    self.status = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}

extension BlogDTO: Identifiable { }
