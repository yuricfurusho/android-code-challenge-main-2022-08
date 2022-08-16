package com.yuricfurusho.userpost

import javax.inject.Inject

class GetUserPostListUseCase @Inject constructor(
    private val userPostRepository: UserPostDummyRepository,
) {

    operator fun invoke(): List<UserPostItem> = userPostRepository.getUserPostItemList()
}