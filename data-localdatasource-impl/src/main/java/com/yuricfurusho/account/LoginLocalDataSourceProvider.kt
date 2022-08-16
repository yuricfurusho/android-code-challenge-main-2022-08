package com.yuricfurusho.account

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class LoginLocalDataSourceProvider {

    @Provides
    fun providesLoginLocalDataSource(): LoginLocalDataSource = LoginLocalDataSourceImpl()
}
