package br.com.vinicius.guardieiro.sousa.searchfeature.data.repository

import br.com.vinicius.guardieiro.sousa.searchfeature.data.map.toSearchSeriesData
import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.api.SearchApi
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.repository.SearchRepository

class SearchRepositoryImpl(private val searchApi : SearchApi) : SearchRepository {
    override suspend fun searchByName(name: String): List<SearchSeriesData>? {
        return searchApi.getSeriesByName(name)?.toSearchSeriesData()
    }
}