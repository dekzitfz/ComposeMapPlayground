package id.adiandrea.mapplayground.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.adiandrea.mapplayground.ui.theme.MapPlaygroundTheme

@Preview
@Composable
fun HomeScreen(
    onMeasureAreaSelected: () -> Unit = {}
) {
    MapPlaygroundTheme {
        Scaffold(Modifier.fillMaxSize()) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            ) {
                Button(onMeasureAreaSelected) {
                    Text("Measure Area")
                }
            }
        }
    }
}