package com.yuricfurusho.user

import com.yuricfurusho.flowwrapper.FlowNetworkResponseWrapper
import com.yuricfurusho.league.LeagueApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class UserRemoteDataSourceProvider {

    @Provides
    fun providesLeagueApi(
        flowWrapper: FlowNetworkResponseWrapper,
        coroutineDispatcher: CoroutineDispatcher,
        leagueApi: LeagueApi
    ): UserRemoteDataSource = UserRemoteDataSourceImpl(
        flowWrapper,
        coroutineDispatcher,
        leagueApi
    )
}