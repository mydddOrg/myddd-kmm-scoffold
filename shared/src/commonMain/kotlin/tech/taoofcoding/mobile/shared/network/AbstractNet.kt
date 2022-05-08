package tech.taoofcoding.mobile.shared.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

abstract class AbstractNet {
    val taoOfCodeUrl = "https://data.taoofcoding.tech/api/collections/get"

    val accessToken = "bb759ac0e273d02ac0f9cd39e4809b"

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }
}