package com.example.ucp2.ui.mata_kuliah

import MataKuliah
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MataKuliahListView(
    navController: NavController,
    mataKuliahList: List<MataKuliah>,
    onDelete: (MataKuliah) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mataKuliahList) { mataKuliah ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("mataKuliahDetail/${mataKuliah.kode}")
                    },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Kode: ${mataKuliah.kode}", style = MaterialTheme.typography.bodyLarge)
                    Text("Nama: ${mataKuliah.nama}", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { navController.navigate("mataKuliahUpdate/${mataKuliah.kode}") }
                        ) {
                            Text("Edit")
                        }
                        Button(
                            onClick = { onDelete(mataKuliah) },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Hapus")
                        }
                    }
                }
            }
        }
    }
}
