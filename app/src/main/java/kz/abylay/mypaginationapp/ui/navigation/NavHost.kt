package kz.abylay.mypaginationapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kz.abylay.mypaginationapp.ui.screen.HelpScreen
import kz.abylay.mypaginationapp.ui.screen.HomeScreen
import kz.abylay.mypaginationapp.ui.screen.MainViewModel
import kz.abylay.mypaginationapp.ui.screen.SettingsScreen

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = ScreenRoute.HOME.query) {
        composable(ScreenRoute.HOME.query) {
            HomeScreen(viewModel = viewModel)
        }
        composable(ScreenRoute.SETTINGS.query) {
            SettingsScreen()
        }
        composable(ScreenRoute.HELP.query) {
            HelpScreen()
        }
    }
}