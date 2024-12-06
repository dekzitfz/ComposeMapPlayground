package id.adiandrea.mapplayground.ui.measurearea

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap
import id.adiandrea.mapplayground.ui.theme.MapPlaygroundTheme

@Preview
@Composable
fun MapMeasureAreaScreen() {
    MapPlaygroundTheme {
        Scaffold(Modifier.fillMaxSize()) { innerPadding ->
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}