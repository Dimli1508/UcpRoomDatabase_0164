package com.example.ucp2.ui.mata_kuliah

import MataKuliah
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MataKuliahDetailView(
    mataKuliah: MataKuliah,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Detail Mata Kuliah", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Kode: ${mataKuliah.kode}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Nama: ${mataKuliah.nama}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("SKS: ${mataKuliah.sks}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Semester: ${mataKuliah.semester}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Jenis: ${mataKuliah.jenis}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Dosen Pengampu: ${mataKuliah.dosenPengampu}")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali")
        }
    }
}
