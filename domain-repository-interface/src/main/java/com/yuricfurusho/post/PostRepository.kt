package com.yuricfurusho.post

import com.yuricfurusho.post.UserPostItem

interface UserPostRepository {
    fun getUserPostItemList(): List<UserPostItem>
}