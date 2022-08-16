package com.yuricfurusho.user

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserList(apiKey: String): Flow<Result<List<User>>>
}