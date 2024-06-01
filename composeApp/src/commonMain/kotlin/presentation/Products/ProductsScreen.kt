package presentation.Products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.seiko.imageloader.rememberImagePainter
import data.util.toColor
import domain.model.Post
import domain.model.Product
import domain.use_cases.GetPostsUseCase
import domain.use_cases.GetProductsUseCase
import org.jetbrains.compose.resources.painterResource
import utils.isDesktop

@Composable
fun ProductsScreen(
    tabNavigator: TabNavigator,
    modifier: Modifier = Modifier
) {
    val viewModel: ProductViewModel = ProductViewModel(GetProductsUseCase())
    val state = viewModel.uiState.collectAsState()

    Box (modifier = Modifier.fillMaxSize()){
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
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                itemsIndexed(state.value.posts){ index,product->
                    println("Índice: $index, Producto: $product")

                    if(isDesktop()){
                        ProductCard(
                            color = "#2980B9",
                            product = product
                        )
                        Spacer(Modifier.height(10.dp))
                    }else{
                        ProductCard(
                            color = "#a0a0a0",
                            product = product
                        )
                        Spacer(Modifier.height(10.dp))
                    }

                    //update when 2 left
                    if((index + 2) == state.value.posts.size && state.value.posts.size != state.value.postsArrayList.size){
                        viewModel.loadNextTenProducts(5)
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .size(50.dp)
                .align(alignment = Alignment.TopEnd)
                //.align(Alignment.BottomEnd)
                .padding(5.dp)

        ) {
            Text(text = state.value.posts.size.toString())
        }
    }
    
}

@Composable
fun ProductCard(
    product: Product,
    color: String = "#ffffff",
    ) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        backgroundColor = Color.Gray
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(product.imgUrl),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.description,
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
