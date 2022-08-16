package com.yuricfurusho.user

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUserList(apiKey: String): Flow<Result<List<User>>> =
        userRemoteDataSource.getUserList(apiKey)
}
