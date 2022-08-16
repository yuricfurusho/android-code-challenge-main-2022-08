package com.yuricfurusho.domain_repo_interface

import com.yuricfurusho.domain_data.PostItem

interface PostRepository {
    fun getPostItemList(): List<PostItem>
}