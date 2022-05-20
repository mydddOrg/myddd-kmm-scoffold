package tech.taoofcoding.mobile.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import tech.taoofcoding.mobile.androidApp.view.BlogItemView
import tech.taoofcoding.mobile.androidApp.viewmodel.BlogViewModel
import tech.taoofcoding.mobile.shared.entity.BlogDTO

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainListViewStateful()
            }
        }
    }

    @Composable
    fun MainListViewStateful(blogViewModel: BlogViewModel = BlogViewModel(this)){
        val scope = rememberCoroutineScope()

        if(blogViewModel.blogs.isEmpty()){
            LaunchedEffect(blogViewModel.blogs) {
                scope.launch {
                    blogViewModel.fetchBlogs()
                }
            }
        }

        LazyColumn {
            items(blogViewModel.blogs, key = { blog -> blog.slug }) { blog ->
                BlogItemView(blogDTO = blog)
            }
        }

    }

    @Composable
    fun MainListView(blogs:List<BlogDTO>){
        LazyColumn {
            items(blogs) { blog ->
                BlogItemView(blogDTO = blog)
            }
        }
    }



    @Preview
    @Composable
    fun previewWelcome() {
        val blogDto  = BlogDTO(
            slug = "",
            date = "2022-01-21",
            title = "ViewModels as source of truth",
            brief = "providing access to the business logic of the application that is usually placed in other layers of the hierarchy such as the business and data layers, and",
            created = 0)

        val blogs = listOf(blogDto,blogDto)

        MaterialTheme {
            MainListView(blogs)
        }
    }
}