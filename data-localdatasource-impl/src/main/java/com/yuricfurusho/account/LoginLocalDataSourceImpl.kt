package com.yuricfurusho.account

import android.content.SharedPreferences
import android.util.Base64
import com.yuricfurusho.localstorage.LeagueStorage
import javax.inject.Inject

class LoginLocalDataSourceImpl @Inject constructor(
    private val sharedPref: SharedPreferences,
) : LoginLocalDataSource {

    override fun getLoginAuth(username: String, password: String): String =
        "Basic " +
                Base64.encodeToString(
                    "$username:$password".toByteArray(),
                    Base64.NO_WRAP
                )

    override fun setApiKey(apiKey: String) {
        with(sharedPref.edit()) {
            putString(LeagueStorage.ACCOUNT_API_KEY, apiKey)
            apply()
        }
        //TODO LEAG-0033 return a boolean
    }

    override fun getApiKey(): String =
        sharedPref.getString(LeagueStorage.ACCOUNT_API_KEY, "") ?: ""
}
