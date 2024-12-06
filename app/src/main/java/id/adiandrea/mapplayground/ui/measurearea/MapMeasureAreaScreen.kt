package id.adiandrea.mapplayground.ui.measurearea

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.rememberMarkerState
import id.adiandrea.mapplayground.ui.theme.MapPlaygroundTheme
import java.text.DecimalFormat

@Preview
@Composable
fun MapMeasureAreaScreen() {
    val locationPoints = remember { mutableStateListOf<LatLng>() }

    fun onMapCLick(latLng: LatLng) {
        locationPoints.add(latLng)
    }

    MapPlaygroundTheme {
        Scaffold(Modifier.fillMaxSize()) { innerPadding ->
            GoogleMap(
                onMapClick = { latLng -> onMapCLick(latLng) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

                locationPoints.forEach {
                    MarkerComposable(
                        state = rememberMarkerState(position = it),
                        title = "Marker by click",
                        anchor = Offset(0.5f, 0.5f)
                    ) {
                        BlueDotMarker()
                    }
                }

                if (locationPoints.isNotEmpty()) {
                    Polygon(
                        points = locationPoints.toList(),
                        strokeColor = Color(0xFF4b94f5),
                        strokeWidth = 4f,
                        strokePattern = arrayListOf(Dash(10f), Gap(4f)),
                        fillColor = Color(0x404b94f5)
                    )

                    if (locationPoints.size > 2) {
                        AreaMarker(locationPoints.toList())
                    }
                }
            }
        }
    }
}

fun List<LatLng>.getCenterLocation(): LatLng {
    var centerLat = 0.0
    var centerLng = 0.0

    for (point in this) {
        centerLat += point.latitude
        centerLng += point.longitude
    }

    centerLat /= this.size
    centerLng /= this.size

    return LatLng(centerLat, centerLng)
}

fun Double.formatDecimal(): String {
    val decimalFormat = DecimalFormat("#.00")
    return decimalFormat.format(this)
}

fun Double.makeItReadable(): String {
    return if (this < 1000000.0) {
        "${this.formatDecimal()} m²"
    } else {
        "${(this / 1000000.0).formatDecimal()} km²"
    }

}