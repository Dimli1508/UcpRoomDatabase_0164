package com.example.ucp2.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dosen")
data class Dosen(
    @PrimaryKey
    val nidn: Int,
    val nama: String,
    val jenisKelamin: String

)
