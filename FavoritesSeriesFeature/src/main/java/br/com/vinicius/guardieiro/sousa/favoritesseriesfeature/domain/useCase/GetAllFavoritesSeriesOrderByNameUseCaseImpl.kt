package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.repository.FavoriteRepository
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel

class GetAllFavoritesSeriesOrderByNameUseCaseImpl(
    private val favoriteRepository : FavoriteRepository
) : GetAllFavoritesSeriesOrderByNameUseCase {
    override suspend fun invoke(): List<FavoriteDomainModel>? {
        return  favoriteRepository.getAllFavoriteSeriesOrderByName()
    }
}