package com.yuricfurusho.userpost

import com.yuricfurusho.post.Post
import com.yuricfurusho.user.User

class UserPostItemBuilder {
    fun from(
        postList: List<Post>,
        userList: MutableList<User>
    ) = postList.map { post ->
        UserPostItem(
            userFullName = userList.first { it.id == post.userId }.name,
            userAvatarUrl = userList.first { it.id == post.userId }.avatarUrl,
            title = post.title,
            description = post.description,
        )
    }
}