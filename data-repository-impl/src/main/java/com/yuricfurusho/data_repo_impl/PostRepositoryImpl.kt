package com.yuricfurusho.data_repo_impl

import com.yuricfurusho.domain_data.DummyData
import com.yuricfurusho.domain_data.PostItem
import com.yuricfurusho.domain_repo_interface.PostRepository

class PostRepositoryImpl : PostRepository {
    override fun getPostItemList(): List<PostItem> = DummyData.postItemList
}