package com.elsonji.coworks.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rate(
    @Json(name = "code")
    val code: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "rate")
    val rate: Double? = null
)