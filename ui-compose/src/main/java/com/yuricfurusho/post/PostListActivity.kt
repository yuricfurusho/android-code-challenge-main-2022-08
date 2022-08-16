package com.yuricfurusho.post

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.yuricfurusho.account.Account
import com.yuricfurusho.account.LoginUseCase
import com.yuricfurusho.composeui.ui.theme.AndroidCodeChallengeMainTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PostListActivity : ComponentActivity() {

    private val vm: PostListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeChallengeMainTheme {
                PostListScreen(vm)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        vm.loadPostList()
    }
}
