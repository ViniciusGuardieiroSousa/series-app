package br.com.vinicius.guardieiro.sousa.searchfeature.di

import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.api.SearchApi
import br.com.vinicius.guardieiro.sousa.searchfeature.data.repository.SearchRepositoryImpl
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.repository.SearchRepository
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.useCase.GetSeriesByNameUseCase
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.useCase.GetSeriesByNameUseCaseImpl
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment.SearchFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview.SearchAdapter
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.viewModel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModules = module{
    single<SearchRepository> { SearchRepositoryImpl(get()) }
    single<GetSeriesByNameUseCase> { GetSeriesByNameUseCaseImpl(get()) }
    factory { SearchAdapter() }
    viewModel { SearchViewModel(get()) }
    factory { provideSearchApi(get()) }
}

fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)
