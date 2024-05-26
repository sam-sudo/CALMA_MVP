package presentation.Products

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.use_cases.GetPostsUseCase
import domain.use_cases.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ProductState())
    val uiState = _uiState.asStateFlow()

    init {
        updateProducts()
    }

    private fun updateProducts(){
        viewModelScope.launch {
            val products = getProductsUseCase()
            products.onRight {
                list ->
                _uiState.update {
                    it.copy(posts = list)
                }
            }.onLeft {
                println( "updateProducts: $it", )
            }

        }
    }

}
