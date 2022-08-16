package com.yuricfurusho.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuricfurusho.account.Account
import com.yuricfurusho.account.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    getPostListUseCase: GetPostListUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _postItemList = getPostListUseCase()
    val postItemList = _postItemList

    fun loadPostList() {
        // example api call to login, feel free to delete this and implement the call to login
        // somewhere else differently depending on your chosen architecture
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val account: Account = loginUseCase("hello", "world")
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
                Log.v(TAG, account.apiKey ?: "")
            } catch (t: Throwable) {
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
                Log.e(TAG, t.message, t)
            }
        }
    }

    companion object {
        private const val TAG = "PostListViewModel"
    }
}
