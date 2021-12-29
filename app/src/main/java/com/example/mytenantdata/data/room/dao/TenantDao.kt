package com.example.mytenantdata.data.room.dao

import androidx.room.*
import com.example.mytenantdata.model.Tenant
import kotlinx.coroutines.flow.Flow

@Dao
interface TenantDao {

    @Insert
    suspend fun insert(tenant: Tenant)

    @Update
    suspend fun update(tenant: Tenant)

    @Delete
    suspend fun delete(tenant: Tenant)

    @Query("SELECT * FROM Tenant")
    fun getAllProperty(): Flow<List<Tenant>>

    @Insert
    fun insertAllProperty(vararg tenant: Tenant)
}