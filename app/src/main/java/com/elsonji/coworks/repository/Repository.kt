package com.elsonji.coworks.repository

import com.elsonji.coworks.api.models.Rate
import retrofit2.Response

interface Repository {
    suspend fun getRateList(): Response<List<Rate>>
}