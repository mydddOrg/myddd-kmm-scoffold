package tech.taoofcoding.mobile.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class ResponseWrapper<T>(val entries:List<T>)
