package com.yuricfurusho.post

import com.yuricfurusho.post.UserPostItem
import com.yuricfurusho.post.UserPostRepository
import javax.inject.Inject

class GetUserPostListUseCase @Inject constructor(
    private val userPostRepository: UserPostRepository,
) {

    operator fun invoke(): List<UserPostItem> = userPostRepository.getUserPostItemList()
}