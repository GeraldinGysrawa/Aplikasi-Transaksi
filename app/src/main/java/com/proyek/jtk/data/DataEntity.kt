package com.proyek.jtk.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val nim: String,
    val email: String,
    val photo: ByteArray
)
