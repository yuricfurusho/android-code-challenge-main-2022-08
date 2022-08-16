package com.yuricfurusho.account

import android.util.Base64
import javax.inject.Inject

class LoginLocalDataSourceImpl @Inject constructor() : LoginLocalDataSource {

    override fun getLoginAuth(username: String, password: String): String =
        "Basic " +
                Base64.encodeToString(
                    "$username:$password".toByteArray(),
                    Base64.NO_WRAP
                )
}
