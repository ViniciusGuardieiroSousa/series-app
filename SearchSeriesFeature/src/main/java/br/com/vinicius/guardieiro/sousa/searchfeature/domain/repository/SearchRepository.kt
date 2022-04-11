package br.com.vinicius.guardieiro.sousa.searchfeature.domain.repository

import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData

interface SearchRepository {

    suspend fun searchByName(name : String) : List<SearchSeriesData>?
}