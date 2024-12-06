package id.adiandrea.mapplayground.ui.measurearea

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.SphericalUtil
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.rememberMarkerState

@Preview
@Composable
fun AreaMarker(locationPoints: List<LatLng> = listOf()) {
    val centerMarkerState = rememberMarkerState(position = locationPoints.getCenterLocation())
    centerMarkerState.position = locationPoints.getCenterLocation()

    val computeArea = SphericalUtil.computeArea(locationPoints)
    val area by remember { mutableDoubleStateOf(computeArea) }.apply {
        doubleValue = computeArea
    }

    MarkerComposable(state = centerMarkerState, keys = arrayOf(area)){
        Box(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF4b94f5))
                .padding(4.dp)
        ) {
            Text(
                text = area.makeItReadable(),
                color = Color.White,
                fontSize = 8.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}