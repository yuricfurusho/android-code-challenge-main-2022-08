package com.yuricfurusho.account

import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginLocalDataSource: LoginLocalDataSource
) : LoginRepository {
    override fun getLoginAuth(username: String, password: String): String =
        loginLocalDataSource.getLoginAuth(username, password)
}