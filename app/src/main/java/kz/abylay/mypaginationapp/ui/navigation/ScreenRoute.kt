package kz.abylay.mypaginationapp.ui.navigation

enum class ScreenRoute {
    HOME, COUNTER, SETTINGS, HELP;

    val query: String
        get() = this.name.lowercase()
}