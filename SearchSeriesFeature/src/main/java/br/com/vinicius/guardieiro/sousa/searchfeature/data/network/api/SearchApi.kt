package br.com.vinicius.guardieiro.sousa.searchfeature.data.network.api

import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model.SearchModelNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/shows")
    suspend fun getSeriesByName(@Query("q") name : String): List<SearchModelNetwork>?
}