package com.yuricfurusho.league

import com.yuricfurusho.account.AccountResponse
import com.yuricfurusho.post.PostResponse
import com.yuricfurusho.user.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Retrofit API interface definition using coroutines. Feel free to change this implementation to
 * suit your chosen architecture pattern and concurrency tools
 */
interface LeagueApi {

    @GET("login")
    suspend fun login(@Header("Authorization") credentials: String?): AccountResponse

    @GET("users")
    suspend fun getUserList(@Header("x-access-token") apiKey: String): List<UserResponse>

    @GET("posts")
    suspend fun getPostList(@Header("x-access-token") apiKey: String): List<PostResponse>

    companion object {
        const val HOST = "https://engineering.league.dev/challenge/api/"
    }
}
