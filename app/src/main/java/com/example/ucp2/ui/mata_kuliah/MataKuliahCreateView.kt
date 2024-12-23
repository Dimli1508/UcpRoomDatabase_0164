package com.example.ucp2.ui.mata_kuliah


import DosenViewModel
import MataKuliah
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2.ui.viewmodel.MataKuliahViewModel


@Composable
fun MataKuliahCreateView(
    navController: NavController,
    mataKuliahViewModel: MataKuliahViewModel,
    dosenViewModel: DosenViewModel
) {
    var kode by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var sks by remember { mutableStateOf("") }
    var semester by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var dosenPengampu by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val dosenList by dosenViewModel.allDosen.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Tambah Mata Kuliah", style = MaterialTheme.typography.bodyLarge)

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
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
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

        // Dropdown untuk memilih dosen pengampu
        Box {
            TextField(
                value = dosenPengampu,
                onValueChange = {},
                label = { Text("Dosen Pengampu") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isDropdownExpanded = true }
            )
            DropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = { isDropdownExpanded = false }
            ) {
                dosenList.forEach {

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (kode.isBlank() || nama.isBlank() || sks.isBlank() || semester.isBlank() || jenis.isBlank() || dosenPengampu.isBlank()) {
                    errorMessage = "Semua field harus diisi dengan benar."
                } else {
                    mataKuliahViewModel.insert(
                        MataKuliah(
                            kode = kode,
                            nama = nama,
                            sks = sks.toIntOrNull() ?: 0,
                            semester = semester,
                            jenis = jenis,
                            dosenPengampu = dosenPengampu
                        )
                    )
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}

