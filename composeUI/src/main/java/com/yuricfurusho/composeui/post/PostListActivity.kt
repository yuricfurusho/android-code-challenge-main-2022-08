package com.yuricfurusho.composeui.post

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yuricfurusho.composeui.ui.theme.AndroidCodeChallengeMainTheme

class PostListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeChallengeMainTheme {
                PostListScreen()
            }
        }
    }
}
