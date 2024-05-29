package presentation.Products

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.use_cases.GetPostsUseCase
import domain.use_cases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import utils.clockNow

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ProductState())
    val uiState = _uiState.asStateFlow()
    val defaultLimit = 10
    val defaultOffset = 0
    init {
        loadProducts(5,1)
    }

    private fun updateProducts(){
        println("-----updateProducts-----")
        val startTime = clockNow()
        viewModelScope.launch {
            val products = getProductsUseCase()
            products.onRight { list ->
                val endTime = clockNow()
                val elapsedTime = endTime - startTime
                println("Tiempo de carga de updateProducts: $elapsedTime ms")
                if(_uiState.value.posts != products){
                    _uiState.value = _uiState.value.copy(posts = list)
                    loadProducts(defaultLimit,defaultOffset)
                }
            }.onLeft {
                println( "updateProducts error: $it", )
            }

        }
    }

    fun loadProducts(limit: Int, offSet: Int){
        println("-----loadProducts-----")
        val startTime = clockNow()
        val products = _uiState.value.posts
        if(products.isNotEmpty() && products.size > offSet){
            val listFiltered = products.subList(offSet,offSet + limit)
            val endTime = clockNow()
            val elapsedTime = endTime - startTime
            println("Tiempo de carga del loadProducts: $elapsedTime ms")
            _uiState.update {
                it.copy(posts = listFiltered)
            }
        }else{
            updateProducts()
        }
    }
    fun loadNextTenProducts(limit: Int){
        println("-----loadNextTenProducts-----")
        val startTime = clockNow()
        val products = _uiState.value.posts
        val offSet = _uiState.value.offSet
        if(products.isNotEmpty() && products.size > offSet ){
            val listFiltered = products.subList(offSet,offSet + limit)
            val endTime = clockNow()
            val elapsedTime = endTime - startTime
            println("Tiempo de carga del loadNextTenProducts: $elapsedTime ms")
            _uiState.update {
                it.copy(
                    posts = listFiltered,
                    offSet = offSet + limit
                )
            }
        }else{
            updateProducts()
        }
    }

}
