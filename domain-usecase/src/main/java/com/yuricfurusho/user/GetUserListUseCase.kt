package com.yuricfurusho.user

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {

    suspend operator fun invoke(apiKey: String): Flow<Result<List<User>>> =
        userRepository.getUserList(apiKey)
}
