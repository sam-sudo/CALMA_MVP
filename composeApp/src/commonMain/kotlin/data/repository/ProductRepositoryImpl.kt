package data.repository

import arrow.core.Either
import domain.repository.RemoteProductsDatasource
import domain.model.Product
import domain.model.builder.ProductBuilder
import domain.repository.ProductRepository
import presentation.Products.Director.Director

class ProductRepositoryImpl (
    private val remoteProductsDatasource: RemoteProductsDatasource,
): ProductRepository{
    override suspend fun getProducts(): Either<String, List<Product>> {
        return Either.catch {
            val director: Director = Director()
            val productBuilder = ProductBuilder()
            val productDataList = remoteProductsDatasource.getProducts()
            productDataList.map { product ->
                if(product.category == "men's clothing"){
                    director.constructorProductA(productBuilder, product)
                }else{
                    director.constructorProductB(productBuilder, product)
                }
                productBuilder.getProduct()
            }
            //productDataList
        }.mapLeft { it.message  ?: "Error getting Products from api or mapping data" }
    }

}