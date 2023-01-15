package com.elsonji.coworks.di

import com.elsonji.coworks.api.CoworksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    companion object {

        @Singleton
        @Provides
        fun provideRetrofitAPI(): CoworksApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(CoworksApi::class.java)
        }

        private const val BASE_URL = "https://bitpay.com"
    }
}