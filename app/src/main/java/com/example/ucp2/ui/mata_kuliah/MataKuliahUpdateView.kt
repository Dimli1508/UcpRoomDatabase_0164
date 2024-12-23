package com.example.ucp2.ui.mata_kuliah

import MataKuliah
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2.ui.viewmodel.MataKuliahViewModel

@Composable
fun MataKuliahUpdateView(
    navController: NavController,
    mataKuliahViewModel: MataKuliahViewModel,
    mataKuliah: MataKuliah
) {
    var kode by remember { mutableStateOf(mataKuliah.kode) }
    var nama by remember { mutableStateOf(mataKuliah.nama) }
    var sks by remember { mutableStateOf(mataKuliah.sks.toString()) }
    var semester by remember { mutableStateOf(mataKuliah.semester) }
    var jenis by remember { mutableStateOf(mataKuliah.jenis) }
    var dosenPengampu by remember { mutableStateOf(mataKuliah.dosenPengampu) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Update Mata Kuliah", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = kode,
            onValueChange = { kode = it },
            label = { Text("Kode Mata Kuliah") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Mata Kuliah") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = sks,
            onValueChange = { sks = it },
            label = { Text("SKS") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = semester,
            onValueChange = { semester = it },
            label = { Text("Semester") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = jenis,
            onValueChange = { jenis = it },
            label = { Text("Jenis") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mataKuliahViewModel.update(
                    MataKuliah(kode, nama, sks.toInt(), semester, jenis, dosenPengampu)
                )
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }
    }
}
