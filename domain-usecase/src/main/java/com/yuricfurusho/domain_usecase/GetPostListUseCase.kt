package com.yuricfurusho.domain_usecase

import com.yuricfurusho.domain_data.PostItem
import com.yuricfurusho.domain_repo_interface.PostRepository
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {

    operator fun invoke(): List<PostItem> = postRepository.getPostItemList()
}