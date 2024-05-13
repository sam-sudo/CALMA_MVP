package data.repository

import arrow.core.Either
import data.network.post.RemoteDataSource
import domain.model.Post
import domain.repository.PostRepository

class PostRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,

    ) : PostRepository{
    override suspend fun getPosts(): Either<String, List<Post>> {
        return Either.catch {
            remoteDataSource.getPost()
        }.mapLeft { it.message ?: "Error getting post from api or mapping data"}
    }

}