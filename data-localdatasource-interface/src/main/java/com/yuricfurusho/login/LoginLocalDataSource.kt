package com.yuricfurusho.login

interface LoginLocalDataSource {
    fun getLoginAuth(username: String, password: String): String
}