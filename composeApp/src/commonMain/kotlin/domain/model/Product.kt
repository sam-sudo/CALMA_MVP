package domain.model

import data.network.products.Rating

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val imgUrl: String,
    val rating: Rating
)