package com.yuricfurusho.login

import com.yuricfurusho.data_local_datasource.LoginLocalDataSource
import com.yuricfurusho.login.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginLocalDataSource: LoginLocalDataSource
) : LoginRepository {
    override fun getLoginAuth(username: String, password: String): String =
        loginLocalDataSource.getLoginAuth(username, password)
}