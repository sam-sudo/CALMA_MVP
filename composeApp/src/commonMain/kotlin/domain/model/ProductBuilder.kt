package domain.model

import data.network.products.Rating

interface ProductBuilder {
    fun reset()
    fun setTitle(tittle :String)
    fun setPrice(price :Double)
    fun setDescription(description :String)
    fun setCategory(category :String)
    fun setImgUrl(imgUrl :String)
    fun setRating(rating : Rating)
}