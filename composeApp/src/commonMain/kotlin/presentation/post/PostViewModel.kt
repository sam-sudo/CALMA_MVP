package presentation.post

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.model.Post
import domain.use_cases.GetPostsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(PostState())
    val uiState = _uiState.asStateFlow()

    init {
        updatePosts()
    }

    private fun updatePosts(){
        viewModelScope.launch {
            val posts = getPostsUseCase()
            posts.onRight {
                list ->
                _uiState.update {
                    it.copy(posts = list)
                }
            }.onLeft {
                println( "updatePosts: $it", )
            }

        }
    }

}
