package com.yuricfurusho.userpost

class UserPostDummyRepositoryImpl : UserPostDummyRepository {
    override fun getUserPostItemDummyList(): List<UserPostItem> = DummyData.userPostItemList
}