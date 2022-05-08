package tech.taoofcoding.mobile.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import androidx.core.view.isVisible
import com.jetbrains.handson.androidApp.R
import kotlinx.coroutines.cancel
import tech.taoofcoding.mobile.shared.BlogSDK
import tech.taoofcoding.mobile.shared.cache.DatabaseDriverFactory


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    private lateinit var blogRecyclerView: RecyclerView
    private lateinit var progressBarView: FrameLayout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val sdk = BlogSDK(DatabaseDriverFactory(this))

    private val blogRvAdapter = BlogRvAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "微言码道"
        setContentView(R.layout.activity_main)

        blogRecyclerView = findViewById(R.id.blogListRv)
        progressBarView = findViewById(R.id.progressBar)
        swipeRefreshLayout = findViewById(R.id.swipeContainer)

        blogRecyclerView.adapter = blogRvAdapter
        blogRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            displayBlogs(true)
        }

        displayBlogs(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    private fun displayBlogs(needReload: Boolean) {
        progressBarView.isVisible = true
        mainScope.launch {
            kotlin.runCatching {
                sdk.getBlogs(needReload)
            }.onSuccess {
                blogRvAdapter.launches = it
                blogRvAdapter.notifyDataSetChanged()
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            progressBarView.isVisible = false
        }
    }
}