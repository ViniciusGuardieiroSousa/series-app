package br.com.vinicius.guardieiro.sousa.detailfeature.data.repository

import br.com.vinicius.guardieiro.sousa.commons.data.database.FavoriteDAO
import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.api.DetailSeriesApi
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository.DetailSeriesRepository
import br.com.vinicius.guardieiro.sousa.detailfeature.data.map.toDetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.data.map.toFavoriteEntity

class DetailSeriesRepositoryImpl(
    private val detailSeriesApi: DetailSeriesApi,
    private val favoriteDAO: FavoriteDAO
) : DetailSeriesRepository {

    override suspend fun getSeriesDetail(id: Long): DetailSeriesDomainModel {
        val detail = detailSeriesApi.getSeriesDetail(id)
        val favorite = favoriteDAO.getById(id) != null
        val episodes = detailSeriesApi.getSeriesEpisode(id)
        return detail.toDetailSeriesDomainModel(favorite, episodes)
    }

    override suspend fun addFavorite(item: DetailSeriesDomainModel) {
        favoriteDAO.insert(item.toFavoriteEntity())
    }

    override suspend fun removeFavorite(item: DetailSeriesDomainModel) {
        favoriteDAO.delete(item.toFavoriteEntity())
    }
}
