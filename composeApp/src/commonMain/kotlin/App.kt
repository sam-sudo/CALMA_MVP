import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition
import di.getSharedModules
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin

import presentation.navigation.BottomBarScreen
import presentation.post.PostScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    startKoin {
        modules(getSharedModules())
    }.koin
    MaterialTheme {
        PostScreen()

    }
}

class MainNavigationScreen: Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        navigator.push(BottomBarScreen())
    }
}