package com.ck.calma.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            _uiState.update {
                it.copy(posts = posts)
            }
        }
    }

}
