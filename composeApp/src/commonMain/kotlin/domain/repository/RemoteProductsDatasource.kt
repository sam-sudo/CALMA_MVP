package domain.repository

import domain.model.Product

interface RemoteProductsDatasource {
    suspend fun getProducts(): List<Product>
}