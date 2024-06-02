package domain.model

import data.network.products.Rating

data class Product(
    val id: Int = 0,
    var title: String? = "",
    var price: Double? = null,
    var description: String? = null,
    var category: String? = null,
    var imgUrl: String? = null,
    var rating: Rating? = null
)