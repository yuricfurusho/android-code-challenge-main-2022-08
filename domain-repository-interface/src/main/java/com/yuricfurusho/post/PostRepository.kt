package com.yuricfurusho.post

import com.yuricfurusho.post.PostItem

interface PostRepository {
    fun getPostItemList(): List<PostItem>
}