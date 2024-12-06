package id.adiandrea.mapplayground.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable object Home : Screen()
    @Serializable object MapMeasureArea : Screen()
}