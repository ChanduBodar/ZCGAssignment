package com.zcgapplication.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String
)