package com.alfrsms.challenge6.di

import com.alfrsms.challenge6.data.local.preference.UserPreferenceDataSource
import com.alfrsms.challenge6.data.local.preference.UserPreferenceDataSourceImpl
import com.alfrsms.challenge6.data.network.datasource.MovieRemoteDataSource
import com.alfrsms.challenge6.data.network.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideMovieDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    abstract fun provideUserDataSource(userPreferenceDataSourceImpl: UserPreferenceDataSourceImpl): UserPreferenceDataSource
}