package com.ck.calma.post

import domain.model.Post

data class PostState(
    val posts: List<Post> = emptyList()
)