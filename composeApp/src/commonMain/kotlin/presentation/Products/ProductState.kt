package presentation.Products

import domain.model.Post
import domain.model.Product

data class ProductState(
    val posts: List<Product> = emptyList()
)