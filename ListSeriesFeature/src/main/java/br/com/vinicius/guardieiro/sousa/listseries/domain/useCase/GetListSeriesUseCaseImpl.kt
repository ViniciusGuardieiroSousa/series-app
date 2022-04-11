package br.com.vinicius.guardieiro.sousa.listseries.domain.useCase

import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.listseries.domain.repository.ListSeriesRepository

class GetListSeriesUseCaseImpl(private val repository: ListSeriesRepository) : GetListSeriesUseCase {
    override suspend fun invoke(): List<ListSeriesDomainModel>? {
        return repository.getAllSeries()
    }
}