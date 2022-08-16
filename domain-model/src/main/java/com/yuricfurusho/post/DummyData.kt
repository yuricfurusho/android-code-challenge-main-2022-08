package com.yuricfurusho.post

object DummyData {

    private val userPostFromClementine = UserPostItem(
        userAvatarUrl = "https://i.postimg.cc/Y9mJztG0/clementine.png",
        userFullName = "Clementine Bauch",
        title = "a quo magni similique perferendis",
        description = "alias dolor cumque impedit blanditiis non eveniet odio maxime blanditiis amet eius quis tempora quia autem rem a provident perspiciatis quia"
    )
    private val userPost1FromPatricia = UserPostItem(
        userAvatarUrl = "https://i.postimg.cc/brxW4LRj/patricia.png",
        userFullName = "Patricia Lebsack",
        title = "enim quo cumque",
        description = "ut voluptatum aliquid illo tenetur nemo sequi quo facilis ipsum rem optio mollitia quas voluptatem eum voluptas qui unde omnis voluptatem iure quasi maxime voluptas nam"
    )
    private val userPost2FromPatricia = UserPostItem(
        userAvatarUrl = "https://i.postimg.cc/brxW4LRj/patricia.png",
        userFullName = "Patricia Lebsack",
        title = "id nihil consequatur molestias animi provident",
        description = "nisi error delectus possimus ut eligendi vitae placeat eos harum cupiditate facilis reprehenderit voluptatem beatae modi ducimus quo illum voluptas eligendi et nobis quia fugit"
    )
    private val userPostFromNicholas = UserPostItem(
        userAvatarUrl = "https://i.postimg.cc/J0VSTSZq/nicholas.png",
        userFullName = "Nicholas Runolfsdottir V",
        title = "consequuntur deleniti eos quia temporibus ab al...",
        description = "voluptatem cumque tenetur consequatur expedita ipsum\n" +
                "\n" +
                "nemo quia explicabo aut eum minima consequatur\n" +
                "\n" +
                "tempore cumque quae est et et in consequuntur voluptatem voluptates aut"
    )

    val userPostItemList = mutableListOf<UserPostItem>()
        .apply {
            add(userPostFromClementine)
            add(userPost1FromPatricia)
            add(userPost2FromPatricia)
            add(userPostFromNicholas)
            add(userPostFromClementine)
            add(userPost1FromPatricia)
            add(userPost2FromPatricia)
            add(userPostFromNicholas)
            add(userPostFromClementine)
            add(userPost1FromPatricia)
            add(userPost2FromPatricia)
            add(userPostFromNicholas)
            add(userPostFromClementine)
            add(userPost1FromPatricia)
            add(userPost2FromPatricia)
            add(userPostFromNicholas)
        }
}