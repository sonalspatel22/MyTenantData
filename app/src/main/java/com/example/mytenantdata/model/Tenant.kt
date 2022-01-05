package com.example.mytenantdata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mytenantdata.data.room.dao.MonthListTypeConverters
import kotlinx.android.parcel.Parcelize
import java.sql.Time
import java.time.LocalDateTime
import java.time.Month
import java.time.MonthDay
import java.time.Year

@Entity
@Parcelize
data class Tenant(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var mobileNumber: String,
    var nativePlace:String="",
    var nativePlaceFullAddress:String?="",
    @TypeConverters(MonthListTypeConverters::class)
    var rentDetail:List<MonthlyPaidRent>?=null
) : Parcelable

@Entity
@Parcelize
data class MonthlyPaidRent(
    var month: Month,
    var monthDay: MonthDay,
    var year: Year,
    var time: Time,
    var amount:Int
):Parcelable
