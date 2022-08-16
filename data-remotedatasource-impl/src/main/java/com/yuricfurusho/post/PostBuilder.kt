package com.yuricfurusho.post

class PostBuilder {
    fun from(postResponse: PostResponse) = Post(
        userId = postResponse.userId,
        title = postResponse.title,
        description = postResponse.body
    )
}
