package presentation.activities

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
import presentation.navigation.tabs.HomeTab

@Composable
fun ActivitiesScreen(tabNavigator: TabNavigator){
    Column( modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Activities Screen")
        Button(
            onClick = {
                tabNavigator.current = HomeTab
            },
            content = {
                Text("Go Home screen!")
            }
        )
    }
}