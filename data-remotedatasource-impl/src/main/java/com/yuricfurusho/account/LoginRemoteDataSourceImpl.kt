package com.yuricfurusho.account

import com.yuricfurusho.league.LeagueApi
import com.yuricfurusho.league.LoginRemoteDataSource
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val leagueApi: LeagueApi
) : LoginRemoteDataSource {
    override suspend fun login(credentials: String): AccountResponse =
        leagueApi.login(credentials)
}