package kz.abylay.mypaginationapp.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String,
    val selected: Boolean = false
)
