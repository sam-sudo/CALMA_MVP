package presentation.Products

import domain.model.Post
import domain.model.Product

data class ProductState(
    val posts: List<Product> = emptyList(),
    val postsArrayList: ArrayList<Product> = ArrayList<Product>(),
    val offSet: Int = 0,
    val lastIndexInList: Int = 0,
)