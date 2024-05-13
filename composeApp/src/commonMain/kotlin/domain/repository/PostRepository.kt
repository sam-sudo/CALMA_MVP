package domain.repository

import arrow.core.Either
import domain.model.Post

interface PostRepository {
    suspend fun getPosts(): Either<String, List<Post>>
}