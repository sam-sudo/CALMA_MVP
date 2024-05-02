package data.network.post

import domain.model.Post

interface RemoteDataSource{
    suspend fun getPost(): List<Post>
}