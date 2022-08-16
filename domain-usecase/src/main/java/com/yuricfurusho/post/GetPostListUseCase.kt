package com.yuricfurusho.post

import com.yuricfurusho.statewrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {

    suspend operator fun invoke(apiKey: String): Flow<Result<List<Post>>> =
        postRepository.getPostList(apiKey)
}
