package com.yuricfurusho.domain_usecase

import com.yuricfurusho.domain_data.DummyData
import com.yuricfurusho.domain_data.PostItem

// TODO: we should add repository dependency later on and have data coming from there.
class GetPostListUseCase {

    operator fun invoke(): List<PostItem> = DummyData.postItemList
}