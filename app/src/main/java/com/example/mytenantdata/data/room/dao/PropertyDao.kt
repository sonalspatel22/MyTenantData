package com.example.mytenantdata.data.room.dao

import androidx.room.*
import com.example.mytenantdata.model.Properti
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDao {

    @Insert
    suspend fun insert(properti: Properti)

    @Update
    suspend fun update(properti: Properti)

    @Delete
    suspend fun delete(properti: Properti)

    @Query("SELECT * FROM Properti")
    fun getAllProperty(): Flow<List<Properti>>

    @Insert
    suspend fun insertAllProperty(vararg properti: Properti)


}