package com.example.ucp2.ui.dosen


import DosenViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DosenListView(navController: NavController, viewModel: DosenViewModel) {
    val dosenList by viewModel.allDosen.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Daftar Dosen", style = MaterialTheme.typography.bodyLarge)

        LazyColumn {
            items(dosenList) { dosen ->
                Text("${dosen.nama} (${dosen.nidn})")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("dosen_create") }) {
            Text("Tambah Dosen")
        }
    }
}