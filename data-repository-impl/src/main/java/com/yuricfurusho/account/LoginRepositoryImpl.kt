package com.yuricfurusho.account

import com.yuricfurusho.league.LoginRemoteDataSource
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginLocalDataSource: LoginLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginRepository {
    override fun getLoginAuth(username: String, password: String): String =
        loginLocalDataSource.getLoginAuth(username, password)

    override fun login(credentials: String): String =
        loginRemoteDataSource.login(credentials)

}