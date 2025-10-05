package com.larkes.neurobuildermultiplatform.data.network.source

import com.larkes.neurobuildermultiplatform.data.network.models.RequestDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.isSuccess

class TestNetworkDataSource(
    private val httpClient: HttpClient
) {
    suspend fun testGetRequest(id: String): String{
        val res = httpClient.get("http://158.160.1.104/items/${id}") {
            contentType(ContentType.Application.Json)
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
        return res.bodyAsText()
    }

    suspend fun testPostRequest(request: RequestDto): String {
        val res = httpClient.post("https://httpbin.org/post") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }
        if (!res.status.isSuccess()) {
            throw Error("Ошибка: ${res.status}")
        }
        return res.bodyAsText()
    }

}