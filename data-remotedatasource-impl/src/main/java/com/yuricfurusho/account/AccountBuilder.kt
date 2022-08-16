package com.yuricfurusho.account

class AccountBuilder {
    fun from(accountResponse: AccountResponse) =
        Account(apiKey = accountResponse.api_key)
}
