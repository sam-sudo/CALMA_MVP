package presentation.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.TabNavigator
import data.util.toColor
import domain.model.Post
import domain.use_cases.GetPostsUseCase
import utils.isDesktop

@Composable
fun PostScreen(
    tabNavigator: TabNavigator,
    modifier: Modifier = Modifier
) {
    val viewModel: PostViewModel = PostViewModel(GetPostsUseCase())
    val state = viewModel.uiState.collectAsState()

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
            .background(MaterialTheme.colors.primary),
    ) {
        LazyVerticalGrid(
            columns = if (isDesktop()) GridCells.Fixed(2) else GridCells.Fixed(1),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.value.posts){ post ->

                if(isDesktop()){
                    PostItem(
                        color = "#2980B9",
                        post = post
                    )
                    Spacer(Modifier.height(10.dp))
                }else{
                    PostItem(
                        color = "#2980B9",
                        post = post
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
    
}

@Composable
fun PostItem(
    color: String,
    post: Post,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        backgroundColor = color.toColor()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6,
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = post.body,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Composable
fun PostItemDesktop(
    color: String,
    post: Post,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        backgroundColor = color.toColor()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6,
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = post.body,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}