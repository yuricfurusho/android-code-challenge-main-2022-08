package com.yuricfurusho.league

import com.yuricfurusho.account.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Retrofit API interface definition using coroutines. Feel free to change this implementation to
 * suit your chosen architecture pattern and concurrency tools
 */
interface LeagueApi {

    @GET("login")
    suspend fun login(@Header("Authorization") credentials: String?): AccountResponse

    companion object {
        const val HOST = "https://engineering.league.dev/challenge/api/"
    }
}
