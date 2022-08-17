package com.yuricfurusho.userpost

import com.yuricfurusho.post.GetPostListUseCase
import com.yuricfurusho.statewrapper.Result
import com.yuricfurusho.user.GetUserListUseCase
import com.yuricfurusho.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetUserPostListUseCase @Inject constructor(
//    private val userPostRepository: UserPostDummyRepository,
    private val getUserListUseCase: GetUserListUseCase,
    private val getPostListUseCase: GetPostListUseCase,
) {

    //    operator fun invoke(): List<UserPostItem> = getUserListUseCase.getUserPostItemList()

    suspend operator fun invoke(apiKey: String): Flow<Result<List<UserPostItem>>> = combine(
        getUserListUseCase(apiKey),
        getPostListUseCase(apiKey)
    ) { userListResult, postListResult ->

        val userList: MutableList<User> = mutableListOf<User>()
        userListResult.mapSuccessData {
            userList.addAll(it)
        }

        postListResult.mapSuccessData { postList ->
            postList.map { post ->
                UserPostItem(
                    userFullName = userList.first { it.id == post.userId }.name,
                    userAvatarUrl = userList.first { it.id == post.userId }.avatarUrl,
                    title = post.title,
                    description = post.description,
                )
            }
        }
    }
}