package com.yuricfurusho.account

import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val getLoginAuthUseCase: GetLoginAuthUseCase
) {

    operator fun invoke(username: String, password: String): String =
        loginRepository.login(getLoginAuthUseCase(username, password))
}
