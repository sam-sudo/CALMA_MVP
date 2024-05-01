package data.repository

import data.network.NetworkDatasource
import data.util.asExternalModel
import domain.model.Post
import domain.repository.PostRepository

class PostRepositoryImpl(
    private val networkDatasource: NetworkDatasource
) : PostRepository{
    override suspend fun getPosts(): List<Post> {
        return networkDatasource.getPosts().map { it.asExternalModel() }
    }

}