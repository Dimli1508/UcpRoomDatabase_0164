package com.example.ucp2.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "menu",
        modifier = modifier.fillMaxSize().background(Color.White)
    ) {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("dosen") {
            DosenScreen()
        }
        composable("mata_kuliah") {
            MataKuliahScreen()
        }
    }
}

@Composable
fun MenuScreen(navController: NavController) {
    var inputText by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pilih Menu", color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (inputText.text.isEmpty()) {
                    errorMessage = "Input tidak boleh kosong untuk memilih Dosen!"
                } else {
                    errorMessage = ""
                    navController.navigate("dosen")
                }
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Dosen")
        }

        Button(
            onClick = {
                if (inputText.text.isEmpty()) {
                    errorMessage = "Input tidak boleh kosong untuk memilih Mata Kuliah!"
                } else {
                    errorMessage = ""
                    navController.navigate("mata_kuliah")
                }
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Mata Kuliah")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Masukkan Input:", color = Color.Black)
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (inputText.text.isEmpty()) {
                errorMessage = "Input tidak boleh kosong!"
            } else {
                errorMessage = ""
                // Lakukan sesuatu dengan inputText
            }
        }) {
            Text("Submit")
        }
    }
}

@Composable
fun DosenScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Halaman Dosen", color = Color.Black)
    }
}

@Composable
fun MataKuliahScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Halaman Mata Kuliah", color = Color.Black)
    }
}
