package data.repository

import arrow.core.Either
import domain.repository.RemoteProductsDatasource
import domain.model.Product
import domain.repository.ProductRepository

class ProductRepositoryImpl (
    private val remoteProductsDatasource: RemoteProductsDatasource,
): ProductRepository{
    override suspend fun getProducts(): Either<String, List<Product>> {
        return Either.catch {
            remoteProductsDatasource.getProducts()
        }.mapLeft { it.message  ?: "Error getting Products from api or mapping data" }
    }

}