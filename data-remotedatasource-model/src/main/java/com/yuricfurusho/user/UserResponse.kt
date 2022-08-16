package com.yuricfurusho.user


const val USER_RESPONSE_INVALID_ID = -1

data class UserResponse(
    val id: Int = USER_RESPONSE_INVALID_ID,
    val avatar: String = "",
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: AddressResponse = AddressResponse(),
    val phone: String = "",
    val website: String = "",
    val company: CompanyResponse = CompanyResponse()
)