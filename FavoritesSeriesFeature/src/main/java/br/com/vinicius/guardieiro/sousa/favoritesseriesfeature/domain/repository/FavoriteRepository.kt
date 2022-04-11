package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.repository

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel

interface FavoriteRepository {

    suspend fun getAllFavoriteSeries() : List<FavoriteDomainModel>?

    suspend fun getAllFavoriteSeriesOrderByName() : List<FavoriteDomainModel>?
}