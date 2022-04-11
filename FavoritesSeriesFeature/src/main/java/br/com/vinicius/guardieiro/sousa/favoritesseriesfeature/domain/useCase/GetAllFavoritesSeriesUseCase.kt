package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel

interface GetAllFavoritesSeriesUseCase {
    suspend fun invoke() : List<FavoriteDomainModel>?
}
