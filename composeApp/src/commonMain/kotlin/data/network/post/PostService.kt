package data.network.post

import data.network.JsonPlaceholderApi
import io.ktor.client.call.body
import io.ktor.client.request.get

class PostService: JsonPlaceholderApi() {

    suspend fun getPosts(): List<NetworkPost> = client.get{
        pathUrl("posts")
    }.body()
}