package com.yuricfurusho.post

class PostItemUIBuilder() {
    fun from(postItem: PostItem) = PostItemUI(
        userFullName = postItem.userFullName,
        userAvatarUrl = postItem.userAvatarUrl,
        title = postItem.title,
        description = postItem.description
    )
}