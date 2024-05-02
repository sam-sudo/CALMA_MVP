package data.util

import data.network.post.NetworkPost
import domain.model.Post

fun NetworkPost.asExternalModel() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)