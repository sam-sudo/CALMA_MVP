package di

import data.network.post.RemotePostDataSource
import data.network.post.PostService
import data.network.post.RemoteDataSource
import data.repository.PostRepositoryImpl
import domain.repository.PostRepository
import domain.use_cases.GetPostsUseCase
import org.koin.dsl.module
import utils.provideDispatcher

/*private val dataModule = module {
    factory { NetworkDataSource(get(), get()) }
    factory { PostService() }
}*/
private val dataModule = module {
    factory { RemotePostDataSource(get(), get()) }
    factory { PostService() }
    factory<RemoteDataSource> { RemotePostDataSource(get(), get()) } // Define RemoteDataSource
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single <PostRepository>{ PostRepositoryImpl(get()) }
    factory { GetPostsUseCase() }
}

private val sharedModule = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModule