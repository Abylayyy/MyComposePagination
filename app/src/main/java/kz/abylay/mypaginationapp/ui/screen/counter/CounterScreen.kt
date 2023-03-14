package kz.abylay.mypaginationapp.ui.screen.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CounterScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        CounterAnimationView(count = count, style = MaterialTheme.typography.h1)
        Button(onClick = {
            count++
        }) {
            Text(text = "Increment")
        }
    }
}