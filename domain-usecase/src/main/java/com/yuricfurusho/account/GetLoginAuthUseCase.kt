package com.yuricfurusho.account

import javax.inject.Inject

class GetLoginAuthUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {

    operator fun invoke(username: String, password: String): String =
        loginRepository.getLoginAuth(username, password)
}
