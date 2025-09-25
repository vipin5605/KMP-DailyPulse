package com.example.dailypulse.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dailypulse.Platform

@Composable
fun AboutScreen() {

    Column {

        AppToolBar(title = "About Screen")
        ContentView()
    }
}

@Composable
private fun ContentView() {
    
    val items = makeItems()

    LazyColumn ( modifier = Modifier.fillMaxSize()) {

        items(items) { row ->

            RowView(title = row.first, secondTitle = row.second)

        }
    }

}

@Composable
fun RowView(title : String, secondTitle : String) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleMedium )
        Text(text = secondTitle, style = MaterialTheme.typography.titleSmall)
    }
    Divider()

}

fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(Pair("Device os ", "${platform.osVersion}"), Pair("Device Name", "${platform.deviceName}"), Pair("Device density", "${platform.density}"))

}

