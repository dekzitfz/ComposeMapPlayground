package id.adiandrea.mapplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.adiandrea.mapplayground.navigation.Screen
import id.adiandrea.mapplayground.ui.home.HomeScreen
import id.adiandrea.mapplayground.ui.measurearea.MapMeasureAreaScreen
import id.adiandrea.mapplayground.ui.theme.MapPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.Home
            ) {
                composable<Screen.Home> {
                    HomeScreen(
                        onMeasureAreaSelected = {
                            navController.navigate(Screen.MapMeasureArea)
                        }
                    )
                }
                composable<Screen.MapMeasureArea> {
                    MapMeasureAreaScreen()
                }
            }
        }
    }
}