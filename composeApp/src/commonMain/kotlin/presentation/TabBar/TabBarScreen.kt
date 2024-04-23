package presentation.TabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class TabBarScreen : Screen {

    @Composable
    override fun Content() {
        println("Content -----")
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(HomeTab, HomeTab2)
                )
            }
        ) {
            Scaffold(
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    BottomNavigation(
                    ) {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(HomeTab2)
                    }
                },

                )
        }
    }

}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        modifier = Modifier.background(color = Color.Cyan),
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(painter = it, contentDescription = tab.options.title)
            }
        }
    )
}