package br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel

interface DetailSeriesRepository {
    suspend fun getSeriesDetail(id : Long): DetailSeriesDomainModel

    suspend fun addFavorite(item : DetailSeriesDomainModel)

    suspend fun removeFavorite(item : DetailSeriesDomainModel)

}