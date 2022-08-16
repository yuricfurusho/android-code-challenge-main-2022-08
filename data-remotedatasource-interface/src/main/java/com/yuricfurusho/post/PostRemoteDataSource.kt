package com.yuricfurusho.post

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface PostRemoteDataSource {
    suspend fun getPostList(apiKey: String): Flow<Result<List<Post>>>
}