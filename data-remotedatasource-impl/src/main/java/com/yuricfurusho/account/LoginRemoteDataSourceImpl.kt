package com.yuricfurusho.account

import com.yuricfurusho.flowwrapper.FlowNetworkResponseWrapper
import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.league.LoginRemoteDataSource
import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val flowWrapper: FlowNetworkResponseWrapper,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val leagueApi: LeagueApi
) : LoginRemoteDataSource {
    override suspend fun login(credentials: String): Flow<Result<Account>> =
        flowWrapper.wrap(coroutineDispatcher) {
            leagueApi.login(credentials)
        }.map { result ->
            result.mapSuccessData { accountResponse ->
                AccountBuilder().from(accountResponse)
            }
        }
}