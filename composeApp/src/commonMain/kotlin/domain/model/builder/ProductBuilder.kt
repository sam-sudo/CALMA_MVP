package domain.model.builder

import data.network.products.Rating
import domain.model.Product
import domain.model.ProductBuilder

class ProductBuilder: ProductBuilder {
    private var product: Product = Product()

    override fun reset() {
        this.product = Product()
    }

    override fun setTitle(tittle: String) {product.title = tittle}
    override fun setPrice(price :Double)  { product.price = price }
    override fun setDescription(description :String)  { product.description = description }
    override fun setCategory(category :String)  { product.category = category }
    override fun setImgUrl(imgUrl :String)  { product.imgUrl = imgUrl }
    override fun setRating(rating : Rating)  { product.rating = rating }

    fun getProduct() :Product{
        val product = this.product
        //Es buena practica resetear el product despues de crearlo
        reset()
        return product
    }
}