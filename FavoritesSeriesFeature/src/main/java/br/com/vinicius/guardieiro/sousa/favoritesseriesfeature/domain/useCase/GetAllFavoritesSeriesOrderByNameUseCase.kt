package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel

interface GetAllFavoritesSeriesOrderByNameUseCase {
    suspend fun invoke() : List<FavoriteDomainModel>?
}
