package com.yuricfurusho.account

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val getLoginAuthUseCase: GetLoginAuthUseCase
) {

    suspend operator fun invoke(username: String, password: String): Flow<Result<Account>> =
        loginRepository.login(getLoginAuthUseCase(username, password))
}
