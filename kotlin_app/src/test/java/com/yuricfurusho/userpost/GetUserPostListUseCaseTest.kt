package com.yuricfurusho.userpost

import com.yuricfurusho.coroutine.MainCoroutineRule
import com.yuricfurusho.post.GetPostListUseCase
import com.yuricfurusho.post.Post
import com.yuricfurusho.statewrapper.Result
import com.yuricfurusho.user.GetUserListUseCase
import com.yuricfurusho.user.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

private const val APY_KEY: String = "DUMMY"

private val POST_LIST_RESULT_FLOW: Flow<Result<List<Post>>> = flow {
    emit(Result.Loading)
}

private val USER_LIST_RESULT_FLOW: Flow<Result<List<User>>> = flow {
    emit(Result.Loading)
}

private val USER_POST_LIST_RESULT_FLOW: Flow<Result<List<UserPostItem>>> = flow {
    emit(Result.Loading)
}

@ExperimentalCoroutinesApi
class GetUserPostListUseCaseTest {

    private val getUserListUseCase: GetUserListUseCase = mockk(relaxed = true)
    private val getPostListUseCase: GetPostListUseCase = mockk(relaxed = true)

    private lateinit var useCase: GetUserPostListUseCase

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        useCase = GetUserPostListUseCase(
            getUserListUseCase,
            getPostListUseCase
        )
    }

    @Test
    fun `useCase SHOULD return same sequence of flows`() {
        coroutineRule.runBlockingTest {
            coEvery {
                getUserListUseCase.invoke(any())
            } returns USER_LIST_RESULT_FLOW
            coEvery {
                getPostListUseCase.invoke(any())
            } returns POST_LIST_RESULT_FLOW

            Assert.assertEquals(USER_POST_LIST_RESULT_FLOW.first(), useCase(APY_KEY).first())
        }
    }
}