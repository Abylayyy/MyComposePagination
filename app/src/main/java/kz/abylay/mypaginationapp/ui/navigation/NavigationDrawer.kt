package kz.abylay.mypaginationapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    var mutableItems by remember {
        mutableStateOf(items)
    }
    LazyColumn(modifier = modifier) {
        items(mutableItems) { item ->
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    mutableItems = mutableItems.map { it.copy(selected = it == item) }
                    onItemClick(item)
                }
                .background(
                    if (item.selected) {
                        Color.LightGray
                    } else {
                        Color.Transparent
                    }
                )
                .padding(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = item.title, style = itemTextStyle, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}