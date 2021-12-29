package com.example.mytenantdata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Properti(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var address: String,
) : Parcelable
