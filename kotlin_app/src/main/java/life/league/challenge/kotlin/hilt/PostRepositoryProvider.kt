package life.league.challenge.kotlin.hilt

import com.yuricfurusho.post.PostRepositoryImpl
import com.yuricfurusho.post.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//TODO Yuri: LEAG-0011: research about adequate place store hilt modules and their organization
// right now because we are doing this here the app module requested domain-repo-interface as a dependency
//TODO Yuri: LEAG-0012: research about correct scoping
@Module
@InstallIn(SingletonComponent::class)
class PostRepositoryProvider {

    @Provides
    fun providesPostRepository(): PostRepository = PostRepositoryImpl()
}