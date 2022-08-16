package com.yuricfurusho.composeui.post

import androidx.lifecycle.ViewModel
import com.yuricfurusho.domain_usecase.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    getPostListUseCase: GetPostListUseCase
) : ViewModel() {

    private val _postItemList = getPostListUseCase()
    val postItemList = _postItemList

}
