package data.network.products

import data.network.FakeStoreApi
import data.network.JsonPlaceholderApi
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText

class ProductService: FakeStoreApi() {
    suspend fun getProducts(): List<NetworkProduct>{
        return client.get{
            pathUrl("products")
        }.body()
    }
}