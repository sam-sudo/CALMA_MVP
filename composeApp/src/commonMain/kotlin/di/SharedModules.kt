package di

import data.network.post.RemotePostDataSourceImpl
import data.network.post.PostService
import data.network.post.RemoteDataSource
import data.network.products.ProductService
import data.network.products.RemoteProductDataSourceImpl
import data.network.products.RemoteProductsDatasource
import data.repository.PostRepositoryImpl
import data.repository.ProductRepositoryImpl
import domain.repository.PostRepository
import domain.repository.ProductRepository
import domain.use_cases.GetPostsUseCase
import domain.use_cases.GetProductsUseCase
import org.koin.dsl.module
import utils.provideDispatcher

/*private val dataModule = module {
    factory { NetworkDataSource(get(), get()) }
    factory { PostService() }
}*/
private val dataModule = module {
    factory { RemotePostDataSourceImpl(get(), get()) }
    factory { PostService() }
    factory<RemoteDataSource> { RemotePostDataSourceImpl(get(), get()) } // Define RemoteDataSource
    factory { RemoteProductDataSourceImpl(get(), get()) }
    factory { ProductService() }
    factory<RemoteProductsDatasource> { RemoteProductDataSourceImpl(get(), get()) } // Define RemoteDataSource
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single <PostRepository>{ PostRepositoryImpl(get()) }
    single <ProductRepository>{ ProductRepositoryImpl(get()) }
    factory { GetPostsUseCase() }
    factory { GetProductsUseCase() }
}

private val sharedModule = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModule