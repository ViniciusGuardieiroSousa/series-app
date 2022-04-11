package br.com.vinicius.guardieiro.sousa.listseries.presentation.map

import br.com.vinicius.guardieiro.sousa.listseries.domain.model.ListSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.listseries.presentation.model.ListSeriesPresentationModel

fun ListSeriesDomainModel.toListSeriesPresentationModel(): ListSeriesPresentationModel {
    return ListSeriesPresentationModel(
        name = name,
        id = id,
        image = image
    )
}

fun List<ListSeriesDomainModel>.toListOfListSeriesPresentationModel(): List<ListSeriesPresentationModel> {
    val result = arrayListOf<ListSeriesPresentationModel>()
    this.forEach {
        result.add(it.toListSeriesPresentationModel())
    }
    return result
}