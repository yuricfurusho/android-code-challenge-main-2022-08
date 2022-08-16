package com.yuricfurusho.account

import com.yuricfurusho.flowwrapper.FlowNetworkResponseWrapper
import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.league.LoginRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class LoginRemoteDataSourceProvider {

    @Provides
    fun providesLeagueApi(
        flowWrapper: FlowNetworkResponseWrapper,
        coroutineDispatcher: CoroutineDispatcher,
        leagueApi: LeagueApi
    ): LoginRemoteDataSource = LoginRemoteDataSourceImpl(
        flowWrapper,
        coroutineDispatcher,
        leagueApi
    )
}