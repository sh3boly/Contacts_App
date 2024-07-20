package com.example.contactsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Contact (
    val name: String,
    val description: String,
    @DrawableRes val picture: Int,
    val phoneNumber: String,
)