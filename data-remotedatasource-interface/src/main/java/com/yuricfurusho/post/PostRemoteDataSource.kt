package com.yuricfurusho.post

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow

interface PostRemoteDataSource {
    fun getPostList(apiKey: String): Flow<Result<List<Post>>>
}