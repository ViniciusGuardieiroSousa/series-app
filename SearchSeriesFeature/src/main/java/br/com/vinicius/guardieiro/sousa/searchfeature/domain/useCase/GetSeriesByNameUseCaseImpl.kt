package br.com.vinicius.guardieiro.sousa.searchfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.repository.SearchRepository

class GetSeriesByNameUseCaseImpl(
    private val searchRepository : SearchRepository
) : GetSeriesByNameUseCase {
    override suspend fun invoke(name : String): List<SearchSeriesData>? {
        return searchRepository.searchByName(name)
    }
}