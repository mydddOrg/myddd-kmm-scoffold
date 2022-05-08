package tech.taoofcoding.mobile.shared.network

import io.ktor.client.call.*
import tech.taoofcoding.mobile.shared.entity.BlogDTO
import tech.taoofcoding.mobile.shared.entity.ResponseWrapper
import io.ktor.client.request.*

class BlogNet: AbstractNet(){
    suspend fun getAllBlogs(): List<BlogDTO>{
        val url = "$taoOfCodeUrl/blogs?token=$accessToken"
        val result:ResponseWrapper<BlogDTO> = httpClient.get(url).body()
        return result.entries
    }

}

