package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.map

import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.model.SearchSeriesPresentationModel

fun SearchSeriesData.toSearchSeriesModel() : SearchSeriesPresentationModel {
    return SearchSeriesPresentationModel(
        id = this.id,
        name = this.name,
        image = this.image
    )
}

fun List<SearchSeriesData>?.toSearchSeriesModel(): List<SearchSeriesPresentationModel> {
    val result = arrayListOf<SearchSeriesPresentationModel>()
    this?.forEach {
        result.add(it.toSearchSeriesModel())
    }
    return result
}