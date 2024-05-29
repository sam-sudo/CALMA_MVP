package data.network.products

import data.util.asExternalModel
import domain.model.Product
import kotlinx.coroutines.withContext
import utils.Dispatcher

class RemoteProductDataSourceImpl(
    private val api: ProductService,
    private val dispatcher: Dispatcher,
): RemoteProductsDatasource {
    override suspend fun getProducts(): List<Product> {
        return withContext(dispatcher.ioDispatcher){
            return@withContext api.getProducts().map {
                it.asExternalModel()
            }
        }
    }

}