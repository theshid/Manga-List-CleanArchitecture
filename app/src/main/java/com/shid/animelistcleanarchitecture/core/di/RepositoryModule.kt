package com.shid.animelistcleanarchitecture.core.di

import com.shid.animelistcleanarchitecture.core.remote.RemoteDataSource
import com.shid.animelistcleanarchitecture.framework.network.api.ApiServices
import com.shid.animelistcleanarchitecture.framework.repository_implementation.DetailAnimeRepository
import com.shid.animelistcleanarchitecture.framework.repository_implementation.SearchAnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDetailAnimeRepository(remoteDataSource: RemoteDataSource): DetailAnimeRepository =
        DetailAnimeRepository.getInstance(remoteDataSource)

    @Provides
    @Singleton
    fun provideSearchAnimeRepository(remoteDataSource: RemoteDataSource): SearchAnimeRepository =
        SearchAnimeRepository.getInstance(remoteDataSource)

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiServices: ApiServices): RemoteDataSource =
        RemoteDataSource.getInstance(apiServices)
}