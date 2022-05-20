package tech.taoofcoding.mobile.androidApp.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import tech.taoofcoding.mobile.shared.BlogSDK
import tech.taoofcoding.mobile.shared.cache.DatabaseDriverFactory
import tech.taoofcoding.mobile.shared.entity.BlogDTO

class BlogViewModel(context: Context):ViewModel() {

    private val blogSDK by lazy { BlogSDK(DatabaseDriverFactory(context)) }

    var blogs by mutableStateOf(listOf<BlogDTO>())
        private set

    // Business logic
    suspend fun fetchBlogs() {
        blogs = blogSDK.getBlogs()
    }
}