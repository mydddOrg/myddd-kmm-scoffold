package tech.taoofcoding.mobile.shared

import tech.taoofcoding.mobile.shared.cache.Database
import tech.taoofcoding.mobile.shared.cache.DatabaseDriverFactory
import tech.taoofcoding.mobile.shared.entity.BlogDTO
import tech.taoofcoding.mobile.shared.network.BlogNet

class BlogSDK (databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = BlogNet()

    @Throws(Exception::class) suspend fun getBlogs(forceReload: Boolean):List<BlogDTO>{
        return api.getAllBlogs().also {
            database.clearDatabase()
            database.batchSaveBlogs(it)
        }
    }
}
