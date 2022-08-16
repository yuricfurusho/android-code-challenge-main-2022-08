package com.yuricfurusho.account

import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.league.LoginRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class LoginRemoteDataSourceProvider {

    @Provides
    fun providesLeagueApi(
        leagueApi: LeagueApi
    ): LoginRemoteDataSource = LoginRemoteDataSourceImpl(leagueApi)
}