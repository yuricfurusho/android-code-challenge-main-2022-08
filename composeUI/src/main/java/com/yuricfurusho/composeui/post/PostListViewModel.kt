package com.yuricfurusho.composeui.post

import androidx.lifecycle.ViewModel
import com.yuricfurusho.domain_data.DummyData

class PostListViewModel : ViewModel() {

    private val _postItemList = DummyData.postItemList
    val postItemList = _postItemList

}
