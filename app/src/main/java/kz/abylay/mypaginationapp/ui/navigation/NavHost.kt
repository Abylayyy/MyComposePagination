package kz.abylay.mypaginationapp.ui.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import kz.abylay.mypaginationapp.ui.screen.HelpScreen
import kz.abylay.mypaginationapp.ui.screen.HomeScreen
import kz.abylay.mypaginationapp.ui.screen.MainViewModel
import kz.abylay.mypaginationapp.ui.screen.SettingsScreen
import kz.abylay.mypaginationapp.ui.screen.counter.CounterScreen

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = ScreenRoute.HOME.query) {
        composable(ScreenRoute.HOME.query) {
            HomeScreen(viewModel = viewModel)
        }
        composable(ScreenRoute.COUNTER.query) {
            CounterScreen()
        }
        composable(ScreenRoute.SETTINGS.query) {
            SettingsScreen()
        }
        composable(route = ScreenRoute.HELP.query, deepLinks = listOf(
            navDeepLink {
                uriPattern = "https://pl-coding.com/{id}"
                action = Intent.ACTION_VIEW
            }
        ), arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
                defaultValue = -1
            }
        )) {
            it.arguments?.getInt("id")?.let { id ->
                HelpScreen(id)
            }
        }
    }
}