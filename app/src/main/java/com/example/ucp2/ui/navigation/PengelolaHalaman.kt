package com.example.ucp2.ui.navigation

import MataKuliah
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2.ui.dosen.DosenCreateView
import com.example.ucp2.ui.dosen.DosenListView
import com.example.ucp2.ui.mainmenu.MainMenu
import com.example.ucp2.ui.mata_kuliah.MataKuliahCreateView
import com.example.ucp2.ui.mata_kuliah.MataKuliahDetailView
import com.example.ucp2.ui.mata_kuliah.MataKuliahListView
import com.example.ucp2.ui.mata_kuliah.MataKuliahUpdateView
import com.example.ucp2.ui.viewmodel.MataKuliahViewModel

@Composable
fun PengelolaHalaman(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_menu") {
        composable("main_menu") {
            MainMenu(navController)        }
        composable("dosen") {
            DosenListView(navController)         }
        composable("mata_kuliah") {
            MataKuliahListView(navController)         }
        composable("dosen_create") {
            DosenCreateView(navController)      }
        composable("mata_kuliah_create") {
            MataKuliahCreateView(navController)     }
        composable(
            "mata_kuliah_detail/{kode}",
            arguments = listOf(navArgument("kode") { type = NavType.StringType })
        ) {
            val kode = it.arguments?.getString("kode")
            if (kode != null) {
                MataKuliahDetailView(
                    mataKuliah = MataKuliah(
                        kode = kode,
                        nama = "",
                        sks = 0,
                        semester = "",
                        jenis = "",
                        dosenPengampu = ""
                    ),
                    onBack = { navController.popBackStack() }
                )
            }
        }
        composable(
            "mata_kuliah_update/{kode}",
            arguments = listOf(navArgument("kode") { type = NavType.StringType })
        ) {
            val kode = it.arguments?.getString("kode")
            if (kode != null) {
                MataKuliahUpdateView(
                    navController = navController,
                    mataKuliahViewModel = MataKuliahViewModel(navController),
                    mataKuliah = MataKuliah(
                        kode = kode,
                        nama = "",
                        sks = 0,
                        semester = "",
                        jenis = "",
                        dosenPengampu = ""
                    )
                )
            }
        }
    }
}
