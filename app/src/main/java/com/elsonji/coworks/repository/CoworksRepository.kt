package com.elsonji.coworks.repository

import com.elsonji.coworks.api.CoworksApi
import com.elsonji.coworks.api.models.Rate
import retrofit2.Response
import javax.inject.Inject

class CoworksRepository @Inject constructor(
    private val api: CoworksApi
) : Repository {

    override suspend fun getRateList(): Response<List<Rate>> {
        return api.getRateList()
    }

}