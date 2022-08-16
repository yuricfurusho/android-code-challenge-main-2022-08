package com.yuricfurusho.league

import com.yuricfurusho.account.Account

interface LoginRemoteDataSource {
    suspend fun login(credentials: String): Account
}