package kz.abylay.mypaginationapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kz.abylay.mypaginationapp.ui.navigation.*
import kz.abylay.mypaginationapp.ui.screen.HomeScreen
import kz.abylay.mypaginationapp.ui.screen.MainViewModel
import kz.abylay.mypaginationapp.ui.theme.MyPaginationAppTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPaginationAppTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val viewModel = viewModel<MainViewModel>()
                val scope = rememberCoroutineScope()
                HomeScreen(viewModel)
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    icon = Icons.Default.Home,
                                    contentDescription = "Go to home screen"
                                ),
                                MenuItem(
                                    id = "counter",
                                    title = "Counter",
                                    icon = Icons.Default.Check,
                                    contentDescription = "Go to counter screen"
                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    icon = Icons.Default.Settings,
                                    contentDescription = "Go to settings screen"
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    icon = Icons.Default.Info,
                                    contentDescription = "Get help"
                                ),
                            ),
                            onItemClick = {
                                navController.navigate(it.id)
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    }) {
                    Navigation(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}