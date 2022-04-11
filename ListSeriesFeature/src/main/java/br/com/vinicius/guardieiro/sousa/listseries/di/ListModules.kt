package br.com.vinicius.guardieiro.sousa.listseries.di

import br.com.vinicius.guardieiro.sousa.listseries.data.network.api.ListSeriesApi
import br.com.vinicius.guardieiro.sousa.listseries.data.repository.ListSeriesRepositoryImpl
import br.com.vinicius.guardieiro.sousa.listseries.domain.repository.ListSeriesRepository
import br.com.vinicius.guardieiro.sousa.listseries.domain.useCase.GetListSeriesUseCase
import br.com.vinicius.guardieiro.sousa.listseries.domain.useCase.GetListSeriesUseCaseImpl
import br.com.vinicius.guardieiro.sousa.listseries.presentation.viewModel.ListSeriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val listModules = module {
    factory<ListSeriesRepository> { ListSeriesRepositoryImpl(get()) }
    factory<GetListSeriesUseCase> { GetListSeriesUseCaseImpl(get()) }
    viewModel { ListSeriesViewModel(get()) }
    factory { provideListSeriesApi(get()) }
}

fun provideListSeriesApi(retrofit: Retrofit): ListSeriesApi =
    retrofit.create(ListSeriesApi::class.java)

