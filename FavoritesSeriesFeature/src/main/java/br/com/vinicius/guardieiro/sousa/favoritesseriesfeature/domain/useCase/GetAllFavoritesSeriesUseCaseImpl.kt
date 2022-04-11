package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.repository.FavoriteRepository

class GetAllFavoritesSeriesUseCaseImpl(
    private val favoriteRepository : FavoriteRepository
) : GetAllFavoritesSeriesUseCase {
    override suspend fun invoke(): List<FavoriteDomainModel>? {
        return favoriteRepository.getAllFavoriteSeries()
    }
}