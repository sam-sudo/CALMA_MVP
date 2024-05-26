package domain.use_cases

import arrow.core.Either
import domain.model.Product
import domain.repository.ProductRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductsUseCase: KoinComponent {
    private val repository: ProductRepository by inject()

    suspend operator fun invoke(): Either<String, List<Product>>{
        return repository.getProducts()
    }
}