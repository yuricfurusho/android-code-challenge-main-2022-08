package com.yuricfurusho.userpost

class UserPostDummyRepositoryImpl : UserPostDummyRepository {
    override fun getUserPostItemList(): List<UserPostItem> = DummyData.userPostItemList
}