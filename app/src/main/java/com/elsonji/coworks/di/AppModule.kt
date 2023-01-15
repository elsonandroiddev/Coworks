package com.elsonji.coworks.di

import com.elsonji.coworks.repository.CoworksRepository
import com.elsonji.coworks.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Singleton
    @Binds
    fun bindRepository(repo: CoworksRepository): Repository
}