package com.yuricfurusho.account

interface LoginLocalDataSource {
    fun getLoginAuth(username: String, password: String): String
    fun setApiKey(apiKey: String?)
    fun getApiKey(): String
}