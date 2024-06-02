package presentation.Products.Director

import domain.model.Product
import domain.model.ProductBuilder

class Director {
    fun constructorProductA(builder: ProductBuilder, product: Product){
        builder.reset()
        builder.setTitle("Product A")
        builder.setPrice(product.price!!)
        builder.setImgUrl(product.imgUrl!!)
        builder.setDescription("description by default object A")

    }
    fun constructorProductB(builder: ProductBuilder, product: Product){
        builder.reset()
        builder.setTitle("Product B")
        builder.setPrice(product.price!!)
        builder.setImgUrl(product.imgUrl!!)
        builder.setDescription("description by default object B")
    }
}