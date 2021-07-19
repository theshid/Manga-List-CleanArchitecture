package com.shid.animelistcleanarchitecture.core.di

import android.content.Context
import com.shid.animelistcleanarchitecture.framework.database.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
@Singleton
@Provides
fun provideDatabase(@ApplicationContext context: Context): AnimeDatabase =
    AnimeDatabase.getInstance(context)

}