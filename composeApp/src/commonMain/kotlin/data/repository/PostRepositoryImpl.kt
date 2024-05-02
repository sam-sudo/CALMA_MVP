package data.repository

import data.network.post.RemoteDataSource
import domain.model.Post
import domain.repository.PostRepository

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,

    ) : PostRepository{
    override suspend fun getPosts(): List<Post> {
        return remoteDataSource.getPost()
    }

}