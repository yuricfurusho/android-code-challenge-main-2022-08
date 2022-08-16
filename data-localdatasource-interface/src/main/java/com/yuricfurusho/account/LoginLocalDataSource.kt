package com.yuricfurusho.account

interface LoginLocalDataSource {
    fun getLoginAuth(username: String, password: String): String
    fun save(account: Account): Boolean
}