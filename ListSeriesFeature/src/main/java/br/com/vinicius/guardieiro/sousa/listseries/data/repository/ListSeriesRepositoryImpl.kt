package br.com.vinicius.guardieiro.sousa.listseries.data.repository

import br.com.vinicius.guardieiro.sousa.listseries.data.map.toListOfListSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.listseries.data.network.api.ListSeriesApi
import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.listseries.domain.repository.ListSeriesRepository

class ListSeriesRepositoryImpl(
    private val listSeriesApi: ListSeriesApi
) : ListSeriesRepository {

    private var actualPage: Int = 0
    private var isLastPage: Boolean = false

    override suspend fun getAllSeries(): List<ListSeriesDomainModel>? {
        return if (isLastPage) {
            null
        } else {
            actualPage++
            val result = listSeriesApi.getAllSeries(actualPage)
            if(result.isEmpty()) {
                isLastPage = true
            }
            result.toListOfListSeriesDomainModel()
        }
    }
}
