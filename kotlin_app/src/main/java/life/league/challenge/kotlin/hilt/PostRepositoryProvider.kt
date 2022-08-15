package life.league.challenge.kotlin.hilt

import com.yuricfurusho.data_repo_impl.PostRepositoryImpl
import com.yuricfurusho.domain_repo_interface.PostRepository
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