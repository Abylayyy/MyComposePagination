package kz.abylay.mypaginationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.abylay.mypaginationapp.ui.screen.MainScreen
import kz.abylay.mypaginationapp.ui.screen.MainViewModel
import kz.abylay.mypaginationapp.ui.theme.MyPaginationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPaginationAppTheme {
                val viewModel = viewModel<MainViewModel>()
                MainScreen(viewModel)
            }
        }
    }
}