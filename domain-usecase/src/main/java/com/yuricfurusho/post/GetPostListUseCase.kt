package com.yuricfurusho.post

import com.yuricfurusho.post.PostItem
import com.yuricfurusho.post.PostRepository
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {

    operator fun invoke(): List<PostItem> = postRepository.getPostItemList()
}