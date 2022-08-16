package com.yuricfurusho.post

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class UserPostRepositoryProvider {

    @Provides
    fun providesUserPostRepository(): UserPostRepository = UserPostRepositoryImpl()
}