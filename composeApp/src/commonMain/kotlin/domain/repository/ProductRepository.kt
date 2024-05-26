package domain.repository

import arrow.core.Either
import domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Either<String, List<Product>>
}