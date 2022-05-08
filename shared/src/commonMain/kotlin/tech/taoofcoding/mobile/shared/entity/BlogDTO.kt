package tech.taoofcoding.mobile.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlogDTO (
    val slug:String,
    val date:String,
    val title:String,
    val brief:String,
    @SerialName("_created")
    val created:Long
)