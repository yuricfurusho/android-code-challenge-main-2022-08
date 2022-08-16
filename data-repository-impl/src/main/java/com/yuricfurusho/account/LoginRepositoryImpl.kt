package com.yuricfurusho.account

import com.yuricfurusho.league.LoginRemoteDataSource
import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginLocalDataSource: LoginLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginRepository {
    override fun getLoginAuth(username: String, password: String): String =
        loginLocalDataSource.getLoginAuth(username, password)

    override suspend fun login(credentials: String): Flow<Result<Account>> =
        loginRemoteDataSource.login(credentials)

}