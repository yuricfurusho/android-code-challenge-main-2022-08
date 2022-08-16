package com.yuricfurusho.post

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postRemoteDataSource: PostRemoteDataSource
) : PostRepository {

    override suspend fun getPostList(apiKey: String): Flow<Result<List<Post>>> =
        postRemoteDataSource.getPostList(apiKey)
}
