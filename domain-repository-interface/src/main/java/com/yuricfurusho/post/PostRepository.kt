package com.yuricfurusho.post

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPostList(apiKey: String): Flow<Result<List<Post>>>
}