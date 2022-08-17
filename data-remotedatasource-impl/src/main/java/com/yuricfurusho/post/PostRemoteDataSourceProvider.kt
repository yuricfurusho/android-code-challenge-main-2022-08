package com.yuricfurusho.post

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
class PostRemoteDataSourceProvider {

    @Provides
    fun providesLeagueApi(
        flowWrapper: FlowNetworkResponseWrapper,
        coroutineDispatcher: CoroutineDispatcher,
        leagueApi: LeagueApi
    ): PostRemoteDataSource = PostRemoteDataSourceImpl(
        flowWrapper,
        coroutineDispatcher,
        leagueApi
    )
}