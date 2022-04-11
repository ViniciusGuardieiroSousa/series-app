package br.com.vinicius.guardieiro.sousa.searchfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData

interface GetSeriesByNameUseCase {
    suspend fun invoke(name : String) : List<SearchSeriesData>?
}
