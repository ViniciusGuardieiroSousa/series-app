package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.di

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.data.repository.FavoriteRepositoryImpl
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.repository.FavoriteRepository
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesOrderByNameUseCaseImpl
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesOrderByNameUseCase
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesUseCase
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesUseCaseImpl
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.viewModel.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val favoriteModules = module{
    single<FavoriteRepository> { FavoriteRepositoryImpl(get()) }
    single<GetAllFavoritesSeriesOrderByNameUseCase> { GetAllFavoritesSeriesOrderByNameUseCaseImpl(get()) }
    single<GetAllFavoritesSeriesUseCase> { GetAllFavoritesSeriesUseCaseImpl(get()) }
    viewModel { FavoriteViewModel(get(), get()) }
}

