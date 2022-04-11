package br.com.vinicius.guardieiro.sousa.listseries.domain.repository

import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel

interface ListSeriesRepository {
    suspend fun getAllSeries(): List<ListSeriesDomainModel>?
}