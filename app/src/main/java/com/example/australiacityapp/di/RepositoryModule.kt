package com.example.australiacityapp.di

import com.example.australiacityapp.data.repository.IStateRepository
import com.example.australiacityapp.data.repository.StateRepositoryImpl
import com.example.australiacityapp.data.source.local.IStateLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesStateRepository(iStateLocalDataSource: IStateLocalDataSource): IStateRepository {
        return StateRepositoryImpl(iStateLocalDataSource)
    }
}