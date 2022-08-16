package com.yuricfurusho.data_local_datasource

interface LoginLocalDataSource {
    fun getLoginAuth(username: String, password: String): String
}