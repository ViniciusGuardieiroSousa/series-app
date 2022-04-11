package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.map

import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.model.FavoritePresentationModel

fun FavoriteDomainModel.toSearchSeriesModel() : FavoritePresentationModel {
    return FavoritePresentationModel(
        id = this.id,
        name = this.name,
        image = this.image
    )
}

fun List<FavoriteDomainModel>?.toSearchSeriesModel(): List<FavoritePresentationModel> {
    val result = arrayListOf<FavoritePresentationModel>()
    this?.forEach {
        result.add(it.toSearchSeriesModel())
    }
    return result
}