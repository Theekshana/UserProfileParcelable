package com.example.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val profileImage: String,
    val name: String,
    val email: String,
    val age: String,
    val number: String

): Parcelable