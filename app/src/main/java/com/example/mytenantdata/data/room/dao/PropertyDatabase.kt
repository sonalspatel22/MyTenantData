package com.example.mytenantdata.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mytenantdata.data.room.dao.*
import com.example.mytenantdata.model.Property
import com.example.mytenantdata.model.Tenant

@Database(entities = [Property::class, Tenant::class], version = 4, exportSchema = true)
@TypeConverters(TenantListTypeConverters::class, MonthListTypeConverters::class,TenantTypeConverters::class)
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
            ) .fallbackToDestructiveMigration().build()
            return instance as PropertyDatabase

        }
    }
}