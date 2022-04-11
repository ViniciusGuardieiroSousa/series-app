package br.com.vinicius.guardieiro.sousa.listseries.data.network.api

import br.com.vinicius.guardieiro.sousa.listseries.data.network.model.ListSeriesNetworkModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ListSeriesApi {
    @GET("shows")
    suspend fun getAllSeries(@Query("page") page : Int): List<ListSeriesNetworkModel>
}