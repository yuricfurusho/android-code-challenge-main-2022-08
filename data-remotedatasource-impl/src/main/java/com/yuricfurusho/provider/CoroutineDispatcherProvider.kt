package com.yuricfurusho.provider

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatcherProvider {

    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}