package data.network.post

import data.util.asExternalModel
import domain.model.Post
import kotlinx.coroutines.withContext
import utils.Dispatcher

class RemotePostDataSourceImpl(
    private val api: PostService,
    private val dispatcher: Dispatcher,
): RemoteDataSource {
    override suspend fun getPost(): List<Post> = withContext(dispatcher.ioDispatcher){
        return@withContext api.getPosts().map { it.asExternalModel() }
    }

}

