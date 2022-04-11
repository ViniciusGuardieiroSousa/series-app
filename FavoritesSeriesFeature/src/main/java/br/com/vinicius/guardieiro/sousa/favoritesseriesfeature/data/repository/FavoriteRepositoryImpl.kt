package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.data.repository

import br.com.vinicius.guardieiro.sousa.commons.data.database.FavoriteDAO
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.data.map.toListOfFavoriteDomainModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(val favoriteDAO: FavoriteDAO) : FavoriteRepository {

    override suspend fun getAllFavoriteSeries(): List<FavoriteDomainModel>? {
        return favoriteDAO.getAll().toListOfFavoriteDomainModel()
    }

    override suspend fun getAllFavoriteSeriesOrderByName(): List<FavoriteDomainModel>? {
        return favoriteDAO.getAllOrderByName().toListOfFavoriteDomainModel()
    }
}