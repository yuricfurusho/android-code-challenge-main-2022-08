package com.yuricfurusho.userpost

import com.yuricfurusho.account.LoginUseCase
import com.yuricfurusho.post.GetPostListUseCase
import com.yuricfurusho.statewrapper.Result
import com.yuricfurusho.user.GetUserListUseCase
import com.yuricfurusho.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetUserPostListUseCase @Inject constructor(
//    private val userPostDummyRepository: UserPostDummyRepository,
    private val getUserListUseCase: GetUserListUseCase,
    private val getPostListUseCase: GetPostListUseCase,
) {

    //    operator fun invoke(): List<UserPostItem> = userPostDummyRepository.getUserPostItemDummyList()

    suspend operator fun invoke(apiKey: String): Flow<Result<List<UserPostItem>>> = combine(
        getUserListUseCase(apiKey),
        getPostListUseCase(apiKey)
    ) { userListResult, postListResult ->
        val userList: MutableList<User> = mutableListOf()
        userListResult.mapSuccessData {
            userList.addAll(it)
        }
        postListResult.mapSuccessData { postList ->
            UserPostItemBuilder().from(postList, userList)
        }
    }
}