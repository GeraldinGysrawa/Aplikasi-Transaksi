package com.proyek.jtk.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.proyek.jtk.data.AppDatabase
import com.proyek.jtk.data.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).profileDao()
    val profile: LiveData<Profile?> = dao.getProfile()
    fun insertProfile(
        nama: String,
        nim: String,
        email: String,
        photo: ByteArray
    ) {
        viewModelScope.launch {
            dao.insertProfile(
                Profile(
                    nama = nama,
                    nim = nim,
                    email = email,
                    photo = photo
                )
            )
        }
    }

    fun updateProfile(profile: Profile) {
        viewModelScope.launch {
            dao.updateProfile(profile)
        }
    }
}
