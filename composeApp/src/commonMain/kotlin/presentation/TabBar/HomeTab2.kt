package presentation.TabBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import presentation.Activities.ActivitiesScreen

object HomeTab2 : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "HOME TAB"
            val icon = rememberVectorPainter(Icons.Filled.AccountBox)

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
        ActivitiesScreen(tabNavigator)
    }
}