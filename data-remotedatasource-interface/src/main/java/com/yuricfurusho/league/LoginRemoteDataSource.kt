package com.yuricfurusho.league

interface LoginRemoteDataSource {
    fun login(credentials: String): String
}