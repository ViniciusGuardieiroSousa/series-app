package br.com.vinicius.guardieiro.sousa.listseries.data.map

import br.com.vinicius.guardieiro.sousa.listseries.data.network.model.ListSeriesNetworkModel
import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel

fun ListSeriesNetworkModel.toListSeriesDomainModel(): ListSeriesDomainModel {
    return ListSeriesDomainModel(
        id = this.id,
        image = this.image?.medium,
        name = this.name
    )
}


fun List<ListSeriesNetworkModel>.toListOfListSeriesDomainModel(): List<ListSeriesDomainModel> {
    val result = arrayListOf<ListSeriesDomainModel>()
    this.forEach {
        result.add(it.toListSeriesDomainModel())
    }
    return result
}