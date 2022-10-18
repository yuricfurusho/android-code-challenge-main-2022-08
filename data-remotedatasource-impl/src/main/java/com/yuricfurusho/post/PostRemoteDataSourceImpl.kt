package com.yuricfurusho.post

import com.yuricfurusho.flowwrapper.FlowNetworkResponseWrapper
import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val flowWrapper: FlowNetworkResponseWrapper,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val leagueApi: LeagueApi
) : PostRemoteDataSource {
    override fun getPostList(apiKey: String): Flow<Result<List<Post>>> =
        flowWrapper.wrap(coroutineDispatcher) {
            leagueApi.getPostList(apiKey)
        }.map { result ->
            result.mapSuccessData { postResponseList ->
                postResponseList.map { postResponse ->
                    PostBuilder().from(postResponse)
                }
            }
        }
}