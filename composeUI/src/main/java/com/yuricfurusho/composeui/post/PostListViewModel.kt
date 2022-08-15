package com.yuricfurusho.composeui.post

import androidx.lifecycle.ViewModel
import com.yuricfurusho.domain_usecase.GetPostListUseCase

// TODO: we should have Hilt create the GetPostListUseCase instance for us
class PostListViewModel : ViewModel() {

    private val _postItemList = GetPostListUseCase().invoke()
    val postItemList = _postItemList

}
