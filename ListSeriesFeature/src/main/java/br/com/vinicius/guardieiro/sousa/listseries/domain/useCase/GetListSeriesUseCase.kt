package br.com.vinicius.guardieiro.sousa.listseries.domain.useCase

import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel

interface GetListSeriesUseCase {
    suspend fun invoke(): List<ListSeriesDomainModel>?
}