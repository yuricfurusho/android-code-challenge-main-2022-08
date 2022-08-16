package com.yuricfurusho.userpost

class UserPostItemUIBuilder() {
    fun from(userPostItem: UserPostItem) = UserPostItemUI(
        userFullName = userPostItem.userFullName,
        userAvatarUrl = userPostItem.userAvatarUrl,
        title = userPostItem.title,
        description = userPostItem.description
    )
}