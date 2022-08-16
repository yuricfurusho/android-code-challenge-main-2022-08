package com.yuricfurusho.provider

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeProvider {

    @Provides
    @DiskWriteScope
    //TODO: Make this provider more specific to disk writes or confirm that this is the correct scope to use
    fun provideCoroutineScope(): CoroutineScope = MainScope()
}