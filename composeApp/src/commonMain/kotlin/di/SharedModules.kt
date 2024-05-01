package di

import data.network.NetworkDatasource
import data.network.PostService
import data.repository.PostRepositoryImpl
import domain.use_cases.GetPostsUseCase
import org.koin.dsl.module
import utils.provideDispatcher

private val dataModule = module {
    factory { NetworkDatasource(get(), get()) }
    factory { PostService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single { PostRepositoryImpl(get()) }
    factory { GetPostsUseCase() }
}

private val sharedModule = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModule