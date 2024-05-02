package data.network.post

import data.util.asExternalModel
import domain.model.Post
import kotlinx.coroutines.withContext
import utils.Dispatcher

class RemotePostDataSource(
    private val api: PostService,
    private val dispatcher: Dispatcher,
): RemoteDataSource {
    override suspend fun getPost(): List<Post> = withContext(dispatcher.ioDispatcher){
        api.getPosts().map { it.asExternalModel() }
    }

}

