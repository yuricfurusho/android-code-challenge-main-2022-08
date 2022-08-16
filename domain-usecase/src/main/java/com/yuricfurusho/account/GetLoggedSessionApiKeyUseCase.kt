package com.yuricfurusho.account

import javax.inject.Inject

class GetLoggedSessionApiKeyUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(): String = loginRepository.getLoggedSessionApikey()
}
