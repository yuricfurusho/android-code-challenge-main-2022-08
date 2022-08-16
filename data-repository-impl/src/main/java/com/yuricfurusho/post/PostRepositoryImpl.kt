package com.yuricfurusho.post

class UserPostRepositoryImpl : UserPostRepository {
    override fun getUserPostItemList(): List<UserPostItem> = DummyData.userPostItemList
}