package presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.TabBar.HomeTab2

@Composable
fun MainScreen(tabNavigator: TabNavigator){
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("MainScreen")
        Button(
            onClick = {
                tabNavigator.current = HomeTab2
            },
            content = {
                Text("Go Activities screen!")
            }
        )
    }
}