package com.yuricfurusho.account

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class LoginLocalDataSourceProvider {

    @Provides
    fun providesLoginLocalDataSource(
        @ApplicationContext context: Context
    ): LoginLocalDataSource = LoginLocalDataSourceImpl(context)
}
