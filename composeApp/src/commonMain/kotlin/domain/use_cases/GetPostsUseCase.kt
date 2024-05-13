package domain.use_cases

import arrow.core.Either
import domain.model.Post
import domain.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostsUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    suspend operator fun invoke(): Either<String, List<Post>> {
        return repository.getPosts()
    }
}