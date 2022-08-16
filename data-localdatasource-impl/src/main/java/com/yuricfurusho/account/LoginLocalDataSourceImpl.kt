package com.yuricfurusho.account

import android.content.Context
import android.util.Base64
import com.yuricfurusho.localstorage.LocalStorage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LoginLocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val appContext: Context
) : LoginLocalDataSource {

    override fun getLoginAuth(username: String, password: String): String =
        "Basic " +
                Base64.encodeToString(
                    "$username:$password".toByteArray(),
                    Base64.NO_WRAP
                )

    override fun save(account: Account) {
        val sharedPref = appContext.getSharedPreferences(
            LocalStorage.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE
        )
        with(sharedPref.edit()) {
            putString(LocalStorage.ACCOUNT_API_KEY, account.apiKey)
            apply()
        }
        //TODO LEAG-0033 return a boolean
    }

    override fun loadApiKey(apiKey: String): String {
        val sharedPref = appContext.getSharedPreferences(
            LocalStorage.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE
        )
        return sharedPref.getString(LocalStorage.ACCOUNT_API_KEY, "") ?: ""
    }
}
