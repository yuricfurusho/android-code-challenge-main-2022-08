package com.yuricfurusho.account

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getLoginAuth(username: String, password: String): String
    suspend fun login(credentials: String): Flow<Result<Account>>
    suspend fun getLoggedSessionApikey(): String
}