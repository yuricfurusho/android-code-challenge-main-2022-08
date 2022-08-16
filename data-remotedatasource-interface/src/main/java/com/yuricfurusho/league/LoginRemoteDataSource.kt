package com.yuricfurusho.league

import com.yuricfurusho.account.AccountResponse

interface LoginRemoteDataSource {
    suspend fun login(credentials: String): AccountResponse
}