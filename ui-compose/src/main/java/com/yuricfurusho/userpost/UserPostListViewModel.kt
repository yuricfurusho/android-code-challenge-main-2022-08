package com.yuricfurusho.userpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuricfurusho.account.Account
import com.yuricfurusho.account.LoginUseCase
import com.yuricfurusho.statewrapper.Result
import com.yuricfurusho.statewrapper.succeeded
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostListViewModel @Inject constructor(
    private val getUserPostListUseCase: GetUserPostListUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _userPostItemListResult =
        MutableStateFlow<Result<List<UserPostItem>>>(Result.Inactive)

    val userPostItemUIList: StateFlow<List<UserPostItemUI>> = _userPostItemListResult
        .filter { it.succeeded }
        .map { userPostItemListResult ->
            (userPostItemListResult as Result.Success).data.map { userPostItem ->
                UserPostItemUIBuilder().from(userPostItem)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    private val _accountResult = MutableStateFlow<Result<Account>>(Result.Inactive)
    val accountResult: StateFlow<Result<Account>> = _accountResult

    fun login() {
        viewModelScope.launch {
            _accountResult.emitAll(loginUseCase("hello", "world"))
        }
    }

    fun loadUserPostList() {
        viewModelScope.launch {
            _userPostItemListResult.emitAll(getUserPostListUseCase())
        }
    }
}
