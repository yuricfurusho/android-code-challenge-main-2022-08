package com.yuricfurusho.account

interface LoginRepository {
    fun getLoginAuth(username: String, password: String): String
    fun login(credentials: String): String
}