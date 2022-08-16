package com.yuricfurusho.post

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PostRepositoryBinder {

    @Binds
    abstract fun bindPostRepository(
        loginRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}
