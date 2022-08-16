package com.yuricfurusho.league

import com.yuricfurusho.account.Account
import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDataSource {
    suspend fun login(credentials: String): Flow<Result<Account>>
}