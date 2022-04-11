package br.com.vinicius.guardieiro.sousa.detailfeature.data.network.api

import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model.DetailEpisodesNetworkModel
import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model.DetailSeriesNetworkModel
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailSeriesApi {
    @GET("shows/{id}")
    suspend fun getSeriesDetail(@Path("id") id : Long): DetailSeriesNetworkModel

    @GET("shows/{id}/episodes")
    suspend fun getSeriesEpisode(@Path("id") id : Long): List<DetailEpisodesNetworkModel>
}