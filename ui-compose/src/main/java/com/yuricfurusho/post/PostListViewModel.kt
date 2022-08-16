package com.yuricfurusho.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuricfurusho.account.Account
import com.yuricfurusho.account.LoginUseCase
import com.yuricfurusho.statewrapper.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostListViewModel @Inject constructor(
    getUserPostListUseCase: GetUserPostListUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _postItemList = getUserPostListUseCase()
    val postItemList = _postItemList

    private val _accountResult = MutableStateFlow<Result<Account>>(Result.Inactive)
    val accountResult: StateFlow<Result<Account>> = _accountResult

    fun loadUserPostList() {
        viewModelScope.launch {
            _accountResult.emitAll(loginUseCase("hello", "world"))
        }
    }
}
