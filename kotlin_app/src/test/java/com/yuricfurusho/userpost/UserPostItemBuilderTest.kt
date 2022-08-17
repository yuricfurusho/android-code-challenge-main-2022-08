package com.yuricfurusho.userpost

import com.yuricfurusho.post.Post
import com.yuricfurusho.user.User
import org.junit.Assert
import org.junit.Before
import org.junit.Test

//TODO LEAG-0047 move this to domain-usecase module

const val TITLE = "title"
const val DESCRIPTION = "desc"
private val POST_LIST: List<Post> = listOf(
    Post(
        userId = 1,
        title = TITLE,
        description = DESCRIPTION
    )
)

const val USER_FULL_NAME = "Ducky"
const val USER_AVATAR_URL = "url1"
private val USER_LIST: List<User> = listOf(
    User(
        id = 1,
        name = USER_FULL_NAME,
        avatarUrl = USER_AVATAR_URL
    )
)

class UserPostItemBuilderTest {

    private lateinit var builder: UserPostItemBuilder

    @Before
    fun setup() {
        builder = UserPostItemBuilder()
    }


    @Test
    fun `UserPostItemBuilder_from SHOULD correctly combine User and Post into UserPostItem`() {
        val userPost: UserPostItem = builder.from(POST_LIST, USER_LIST)[0]

        Assert.assertEquals(USER_FULL_NAME, userPost.userFullName)
        Assert.assertEquals(USER_AVATAR_URL, userPost.userAvatarUrl)
        Assert.assertEquals(TITLE, userPost.title)
        Assert.assertEquals(DESCRIPTION, userPost.description)
    }
}
