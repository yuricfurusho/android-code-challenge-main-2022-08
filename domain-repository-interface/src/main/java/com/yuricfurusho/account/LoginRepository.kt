package com.yuricfurusho.account

interface LoginRepository {
    fun getLoginAuth(username: String, password: String): String
    suspend fun login(credentials: String): Account
}