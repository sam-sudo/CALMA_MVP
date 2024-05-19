package presentation.navigation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import presentation.activities.ActivitiesScreen
import presentation.post.PostScreen

object PostTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Post TAB"
            val icon = rememberVectorPainter(Icons.Filled.Done)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val tabNavigator = LocalTabNavigator.current
        PostScreen(tabNavigator)
    }
}