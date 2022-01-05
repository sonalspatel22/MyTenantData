package com.example.mytenantdata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

import androidx.room.TypeConverters
import com.example.mytenantdata.data.room.dao.TenantListTypeConverters
import com.example.mytenantdata.data.room.dao.TenantTypeConverters
import kotlinx.android.parcel.Parcelize
import java.io.File

@Entity
@Parcelize
data class Property(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var address: String,
    @TypeConverters(TenantListTypeConverters::class)
    val listofTenants: List<Tenant>? = null,
    @TypeConverters(TenantTypeConverters::class)
    var currentTenant: Tenant? = null,
    var currentRent: Int = 0,
    var currentPropertyValue: Int = 0,
    var images:String=""
) : Parcelable
