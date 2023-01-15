package com.elsonji.coworks.api

import com.elsonji.coworks.api.models.Rate
import retrofit2.Response
import retrofit2.http.GET

interface CoworksApi {
    @GET("/api/rates")
    suspend fun getRateList(): Response<List<Rate>>
}