package data.network

import kotlinx.coroutines.withContext
import utils.Dispatcher

class NetworkDatasource(
    private val api: PostService,
    private val dispatcher: Dispatcher
) {
    suspend fun getPosts() = withContext(dispatcher.ioDispatcher){
        api.getPosts()
    }
}