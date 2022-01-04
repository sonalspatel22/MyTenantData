package com.example.mytenantdata.data.room.dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.example.mytenantdata.model.Tenant
import com.google.gson.reflect.TypeToken
import com.example.mytenantdata.data.room.dao.TenantListTypeConverters
import com.example.mytenantdata.model.MonthlyPaidRent

object TenantListTypeConverters {
    private val gson = Gson()
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Tenant>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Tenant?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Tenant?>?): String? {
        return gson.toJson(someObjects)
    }
}

object TenantTypeConverters {
    private val gson = Gson()
    @TypeConverter
    fun stringToSomeObjectList(data: String?): Tenant? {
        if (data == null) {
            return null
        }
        val listType = object : TypeToken<Tenant?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Tenant?): String {
        return gson.toJson(someObjects)
    }
}

object MonthListTypeConverters {
    private val gson = Gson()
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<MonthlyPaidRent> {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<MonthlyPaidRent?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<MonthlyPaidRent?>?): String {
        return gson.toJson(someObjects)
    }
}