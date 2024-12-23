package com.example.ucp2.ui.mainmenu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenu(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("dosen") }) {
            Text("Kelola Dosen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("mata_kuliah") }) {
            Text("Kelola Mata Kuliah")
        }
    }
}