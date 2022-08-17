package com.yuricfurusho.account

import com.yuricfurusho.league.LoginRemoteDataSource
import com.yuricfurusho.provider.DiskWriteScope
import com.yuricfurusho.statewrapper.Result
import com.yuricfurusho.statewrapper.succeeded
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginLocalDataSource: LoginLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource,
    @DiskWriteScope private val writingCoroutineScope: CoroutineScope,
) : LoginRepository {
    override fun getLoginAuth(username: String, password: String): String =
        loginLocalDataSource.getLoginAuth(username, password)

    override suspend fun login(credentials: String): Flow<Result<Account>> =
        loginRemoteDataSource.login(credentials)
            .also { accountResultFlow -> //TODO LEAG-0044 extract wrapper/unwrapper saving apiKey to function review Dispatcher, should be IO
                writingCoroutineScope.launch(Dispatchers.Default) {
                    loginLocalDataSource.setApiKey(
                        accountResultFlow
                            .filter { it.succeeded }
                            .map { accountResult ->
                                (accountResult as Result.Success).data.apiKey
                            }.lastOrNull() ?: ""
                    )
                }
            }


    override suspend fun getLoggedSessionApikey(): String = loginLocalDataSource.getApiKey()
}
