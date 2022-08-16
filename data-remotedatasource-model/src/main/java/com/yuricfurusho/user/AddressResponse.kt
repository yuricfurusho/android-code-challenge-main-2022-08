package com.yuricfurusho.user

data class AddressResponse(
    val street: String = "",
    val suite: String = "",
    val city: String = "",
    val zipcode: String = "",
    val geo: GeoResponse = GeoResponse()
)