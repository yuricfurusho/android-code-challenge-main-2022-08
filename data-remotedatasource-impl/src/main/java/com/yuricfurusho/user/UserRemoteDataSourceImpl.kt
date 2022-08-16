package com.yuricfurusho.user

import com.yuricfurusho.flowwrapper.FlowNetworkResponseWrapper
import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val flowWrapper: FlowNetworkResponseWrapper,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val leagueApi: LeagueApi
) : UserRemoteDataSource {
    override suspend fun getUserList(apiKey: String): Flow<Result<List<User>>> =
        flowWrapper.wrap(coroutineDispatcher) {
            leagueApi.getUserList(apiKey)
        }.map { result ->
            result.mapSuccessData { userResponseList ->
                userResponseList.map { userResponse ->
                    UserBuilder().from(userResponse)
                }
            }
        }
}