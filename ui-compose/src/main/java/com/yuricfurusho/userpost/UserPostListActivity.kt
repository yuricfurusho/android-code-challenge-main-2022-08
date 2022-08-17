package com.yuricfurusho.userpost

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.yuricfurusho.composeui.ui.theme.AndroidCodeChallengeMainTheme
import com.yuricfurusho.statewrapper.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserPostListActivity : ComponentActivity() {

    private val vm: UserPostListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeChallengeMainTheme {
                UserPostListScreen(vm)
            }
        }
        lifecycleScope.launch {
            vm.accountResult.flowWithLifecycle(lifecycle).collect {
                when (it) {
                    // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger and move it to data layer
                    is Result.Success -> {
                        Log.v(TAG, it.data.apiKey ?: "")
                        vm.loadUserPostList(it.data.apiKey ?: "")
                    }
                    is Result.Error -> Log.e(TAG, it.errorMessage)
                    is Result.Inactive -> Unit
                    is Result.Loading -> Unit //TODO LEAG-0029: add UI feedback for loading
                    is Result.NetworkError -> Log.e(TAG, "Network Error")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        vm.login()
    }

    companion object {
        private const val TAG = "UserPostListActivity"
    }
}
