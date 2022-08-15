package com.yuricfurusho.composeui.post

import com.yuricfurusho.domain_data.PostItem

class PostItemUIBuilder() {
    fun from(postItem: PostItem) = PostItemUI(
        userFullName = postItem.userFullName,
        userAvatarUrl = postItem.userAvatarUrl,
        title = postItem.title,
        description = postItem.description
    )
}