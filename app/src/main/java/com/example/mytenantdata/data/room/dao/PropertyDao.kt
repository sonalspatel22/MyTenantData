package com.example.mytenantdata.data.room.dao

import androidx.room.*
import com.example.mytenantdata.model.Property
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDao {

    @Insert
    suspend fun insert(property: Property)

    @Update
    suspend fun update(property: Property)

    @Delete
    suspend fun delete(property: Property)

    @Query("SELECT * FROM Property")
    fun getAllProperty(): Flow<List<Property>>

    @Insert
    suspend fun insertAllProperty(vararg property: Property)


}