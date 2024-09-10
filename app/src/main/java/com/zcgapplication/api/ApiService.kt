package com.zcgapplication.api

import com.zcgapplication.model.ItemType
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("5BEJ")
    suspend fun getBlocks(): ArrayList<ItemType>
}