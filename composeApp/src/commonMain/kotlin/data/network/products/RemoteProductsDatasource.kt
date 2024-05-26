package data.network.products

import domain.model.Product

interface RemoteProductsDatasource {
    suspend fun getProducts(): List<Product>
}