package com.proyek.jtk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfileDao {

    @Insert
    suspend fun insertProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): LiveData<Profile?>




}
