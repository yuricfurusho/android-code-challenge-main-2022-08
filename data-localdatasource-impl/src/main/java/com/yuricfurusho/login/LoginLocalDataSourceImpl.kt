package com.yuricfurusho.login

import android.util.Base64
import com.yuricfurusho.data_local_datasource.LoginLocalDataSource
import javax.inject.Inject

class LoginLocalDataSourceImpl @Inject constructor() : LoginLocalDataSource {

    override fun getLoginAuth(username: String, password: String): String =
        "Basic " +
                Base64.encodeToString(
                    "$username:$password".toByteArray(),
                    Base64.NO_WRAP
                )
}
