package kz.abylay.mypaginationapp.ui.screen

import kz.abylay.mypaginationapp.data.PageData

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<PageData> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)