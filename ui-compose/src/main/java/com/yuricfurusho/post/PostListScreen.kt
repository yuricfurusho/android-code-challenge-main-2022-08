package com.yuricfurusho.post

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yuricfurusho.composeui.R
import com.yuricfurusho.composeui.ui.theme.AndroidCodeChallengeMainTheme
import com.yuricfurusho.composeui.ui.theme.Divider10pc

@Composable
fun UserPostListScreen(vm: UserPostListViewModel) {
    val userPostItemUIList = vm.userPostItemList.map {
        UserPostItemUIBuilder().from(it)
    }

    UserPostList(userPostItemUIList)
}

@Composable
fun UserPostList(userPostList: List<UserPostItemUI>) {
    LazyColumn {
        itemsIndexed(userPostList) { index, userPostItemUI ->
            UserPostItem(userPostItemUI)
            if (index < userPostList.lastIndex)
                Divider(
                    modifier = Modifier.padding(start = 12.dp),
                    color = Divider10pc
                )
        }
    }
}

@Composable
fun UserPostItem(userPostItemUI: UserPostItemUI) {
    Column(modifier = Modifier.padding(12.dp)) {
        UserPostItemHeader(userPostItemUI.userAvatarUrl, userPostItemUI.userFullName)
        Spacer(modifier = Modifier.height(8.dp))
        UserPostItemBody(userPostItemUI.title, userPostItemUI.description)
    }
}

@Composable
private fun UserPostItemHeader(userAvatarUrl: String, userFullName: String) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Max),
    ) {
        UserAvatarImage(userAvatarUrl)
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = userFullName,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun UserAvatarImage(userAvatarUrl: String) {
    GlideImage(
        modifier = Modifier.size(48.dp),
        imageModel = userAvatarUrl,
        placeHolder = ImageVector.vectorResource(R.drawable.ic_generic_user_avatar),
        previewPlaceholder = R.drawable.ic_generic_user_avatar,
        error = ImageVector.vectorResource(R.drawable.ic_generic_user_avatar),
        requestOptions = {
            RequestOptions()
                .override(100, 100)
                .circleCrop()
        },
    )
}

@Composable
private fun UserPostItemBody(title: String, description: String) {
    Column {
        Text(
            text = title,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCodeChallengeMainTheme {
        UserPostList(DummyUIData.userPostItemUIList)
    }
}