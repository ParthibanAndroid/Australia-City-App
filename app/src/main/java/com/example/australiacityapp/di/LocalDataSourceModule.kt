package com.example.australiacityapp.di

import com.example.australiacityapp.data.source.local.IStateLocalDataSource
import com.example.australiacityapp.data.source.local.StateLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class LocalDataSourceModule {

    @Singleton
    @Binds
    abstract fun providesStateLocalDataSource(stateLocalDataSourceImpl: StateLocalDataSourceImpl) : IStateLocalDataSource
}