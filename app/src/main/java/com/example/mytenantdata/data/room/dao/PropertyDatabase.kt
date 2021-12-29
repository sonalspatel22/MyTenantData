package com.example.mytenantdata.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytenantdata.data.room.dao.PropertyDao
import com.example.mytenantdata.data.room.dao.TenantDao
import com.example.mytenantdata.model.Properti
import com.example.mytenantdata.model.Tenant

@Database(entities = [Properti::class, Tenant::class], version = 1, exportSchema = true)
abstract class PropertyDatabase : RoomDatabase() {

    abstract fun getPropertyDao(): PropertyDao

    abstract fun getTenantDao(): TenantDao


    companion object {
        private var instance: PropertyDatabase? = null

        @Synchronized
        fun getInstance(context: Context): PropertyDatabase {
            instance = Room.databaseBuilder(
                context.applicationContext,
                PropertyDatabase::class.java,
                "PropertyDataBase"
            ).build()
            return instance as PropertyDatabase

        }
    }
}