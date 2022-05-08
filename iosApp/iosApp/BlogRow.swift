//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Ekaterina.Petrova on 25.08.2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BlogRow: View {
    var blog: BlogDTO

    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text(blog.title).font(Font.headline)
                Text(String(blog.date)).font(Font.footnote)
                Text(blog.brief).font(Font.footnote)
            }
            Spacer()
        }
    }
}
