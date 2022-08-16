package com.yuricfurusho.post

class UserPostItemUIBuilder() {
    fun from(postItem: UserPostItem) = UserPostItemUI(
        userFullName = postItem.userFullName,
        userAvatarUrl = postItem.userAvatarUrl,
        title = postItem.title,
        description = postItem.description
    )
}