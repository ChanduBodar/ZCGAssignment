package com.zcgapplication.model

import com.google.gson.annotations.SerializedName

data class ItemType(
    @SerializedName("sectionType")
    val sectionType: String,
    @SerializedName("items")
    val items: ArrayList<Item>,
)