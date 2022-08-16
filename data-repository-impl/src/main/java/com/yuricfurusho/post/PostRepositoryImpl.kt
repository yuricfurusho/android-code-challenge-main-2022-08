package com.yuricfurusho.post

class PostRepositoryImpl : PostRepository {
    override fun getPostItemList(): List<PostItem> = DummyData.postItemList
}