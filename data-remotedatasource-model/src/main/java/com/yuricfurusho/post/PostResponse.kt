package com.yuricfurusho.post

const val POST_RESPONSE_INVALID_ID = -1

data class PostResponse(
    var userId: Int = POST_RESPONSE_INVALID_ID,
    var id: Int = POST_RESPONSE_INVALID_ID,
    var title: String = "",
    var body: String = ""
)