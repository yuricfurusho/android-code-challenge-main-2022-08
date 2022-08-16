package com.yuricfurusho.userpost

class UserPostRepositoryImpl : UserPostRepository {
    override fun getUserPostItemList(): List<UserPostItem> = DummyData.userPostItemList
}