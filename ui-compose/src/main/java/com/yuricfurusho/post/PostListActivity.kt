package com.yuricfurusho.post

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.yuricfurusho.composeui.ui.theme.AndroidCodeChallengeMainTheme
import dagger.hilt.android.AndroidEntryPoint

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
}
