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
fun PostListScreen(vm: PostListViewModel) {
    val postItemUIList = vm.postItemList.map {
        PostItemUIBuilder().from(it)
    }

    PostList(postItemUIList)
}

@Composable
fun PostList(postList: List<PostItemUI>) {
    LazyColumn {
        itemsIndexed(postList) { index, postItemUI ->
            PostItem(postItemUI)
            if (index < postList.lastIndex)
                Divider(
                    modifier = Modifier.padding(start = 12.dp),
                    color = Divider10pc
                )
        }
    }
}

@Composable
fun PostItem(postItemUI: PostItemUI) {
    Column(modifier = Modifier.padding(12.dp)) {
        PostItemHeader(postItemUI.userAvatarUrl, postItemUI.userFullName)
        Spacer(modifier = Modifier.height(8.dp))
        PostItemBody(postItemUI.title, postItemUI.description)
    }
}

@Composable
private fun PostItemHeader(userAvatarUrl: String, userFullName: String) {
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
private fun PostItemBody(title: String, description: String) {
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
        PostList(DummyUIData.postItemUIList)
    }
}