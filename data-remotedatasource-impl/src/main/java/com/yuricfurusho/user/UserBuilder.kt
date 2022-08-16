package com.yuricfurusho.user

class UserBuilder {
    fun from(userResponse: UserResponse) = User(
        id = userResponse.id,
        name = userResponse.name,
        avatarUrl = userResponse.avatar
    )
}
