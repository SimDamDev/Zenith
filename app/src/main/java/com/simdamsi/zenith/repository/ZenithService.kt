package com.simdamsi.zenith.repository

import com.simdamsi.zenith.model.Mountain
import retrofit2.Call
import retrofit2.http.GET

interface ZenithService {
    @GET("mountain.json")
    fun get(): Call<List<Mountain>>
}