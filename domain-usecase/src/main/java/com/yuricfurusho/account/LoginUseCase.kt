package com.yuricfurusho.account

import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val getLoginAuthUseCase: GetLoginAuthUseCase
) {

    suspend operator fun invoke(username: String, password: String): Account =
        loginRepository.login(getLoginAuthUseCase(username, password))
}
