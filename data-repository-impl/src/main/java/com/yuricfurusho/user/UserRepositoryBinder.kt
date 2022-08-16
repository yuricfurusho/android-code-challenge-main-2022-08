package com.yuricfurusho.user

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryBinder {

    @Binds
    abstract fun bindUserRepository(
        loginRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}
