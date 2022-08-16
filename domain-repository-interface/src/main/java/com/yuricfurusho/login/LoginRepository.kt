package com.yuricfurusho.login

interface LoginRepository {
    fun getLoginAuth(username: String, password: String): String
}