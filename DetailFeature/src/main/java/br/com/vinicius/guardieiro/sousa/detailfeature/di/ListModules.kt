package br.com.vinicius.guardieiro.sousa.detailfeature.di

import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.api.DetailSeriesApi
import br.com.vinicius.guardieiro.sousa.detailfeature.data.repository.DetailSeriesRepositoryImpl
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository.DetailSeriesRepository
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase.*
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.viewModel.DetailSeriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val detailModules = module {
    single<DetailSeriesRepository> { DetailSeriesRepositoryImpl(get(), get()) }
    single<GetSeriesDetailUseCase> { GetSeriesDetailUseCaseImpl(get()) }
    single<AddSeriesToFavoriteUseCase> { AddSeriesToFavoriteUseCaseImpl(get()) }
    single<RemoveSeriesToFavoriteUseCase> { RemoveSeriesToFavoriteUseCaseImpl(get()) }
    viewModel { DetailSeriesViewModel(get(), get(), get()) }
    factory { provideListSeriesApi(get()) }
}

fun provideListSeriesApi(retrofit: Retrofit): DetailSeriesApi =
    retrofit.create(DetailSeriesApi::class.java)
