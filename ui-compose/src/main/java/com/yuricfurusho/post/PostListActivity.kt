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
    @Inject lateinit var loginUseCase: LoginUseCase

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

        // example api call to login, feel free to delete this and implement the call to login
        // somewhere else differently depending on your chosen architecture
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val account: Account = loginUseCase("hello", "world")
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
                Log.v(TAG, account.apiKey ?: "")
            } catch (t : Throwable) {
                // TODO LEAG-0014: Replace Android logging with java.util.logging.Logger.
                Log.e(TAG, t.message, t)
            }
        }
    }

    companion object {
        private const val TAG = "PostListActivity"
    }
}
