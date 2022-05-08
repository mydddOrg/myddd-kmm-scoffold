package tech.taoofcoding.mobile.shared.cache

import tech.taoofcoding.mobile.shared.entity.BlogDTO

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllBlog()
        }
    }

    internal fun batchSaveBlogs(blogs: List<BlogDTO>) {
        dbQuery.transaction {
            blogs.forEach {
                insertBlog(it)
            }
        }
    }

    private fun insertBlog(blog: BlogDTO){
        dbQuery.insertBlog(
            Blog(
                slug = blog.slug,
                date = blog.date,
                title = blog.title,
                brief = blog.brief,
                created = blog.created
            )
        )
    }
}