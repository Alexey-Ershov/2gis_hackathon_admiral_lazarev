package com.larkes.neurobuildermultiplatform.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


expect class HttpEngineFactory constructor() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}

//class HttpClientFactory {
//
//    private val httpClient = HttpClient(CIO) {
//       install(ContentNegotiation) {
//            json(Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            })
//        }
//
//        install(HttpTimeout) {
//            connectTimeoutMillis = 159000
//            requestTimeoutMillis = 500000
//        }
//    }
//
//    fun get() = httpClient
//
//}