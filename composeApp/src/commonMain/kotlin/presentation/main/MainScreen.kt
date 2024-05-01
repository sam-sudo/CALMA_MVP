package presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.navigation.tabs.ActivitiesTab

@Composable
fun MainScreen(tabNavigator: TabNavigator){
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("MainScreen")
        Button(
            onClick = {
                tabNavigator.current = ActivitiesTab
            },
            content = {
                Text("Go Activities screen!")
            }
        )
    }
}