package com.yuricfurusho.userpost

interface UserPostRepository {
    fun getUserPostItemList(): List<UserPostItem>
}