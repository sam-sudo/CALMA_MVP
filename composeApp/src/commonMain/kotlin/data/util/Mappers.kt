package data.util

import androidx.compose.ui.graphics.Color
import data.network.post.NetworkPost
import domain.model.Post

fun NetworkPost.asExternalModel() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun String.toColor(): androidx.compose.ui.graphics.Color {
    return try {
        val colorLong = this.removePrefix("#").toLong(16)
        when (this.length) {
            7 -> Color(colorLong or 0x00000000FF000000) // #RRGGBB
            9 -> Color(colorLong) // #AARRGGBB
            else -> throw IllegalArgumentException("Unknown color format")
        }
    } catch (e: Exception) {
        throw IllegalArgumentException("Could not parse color: $this", e)
    }
}