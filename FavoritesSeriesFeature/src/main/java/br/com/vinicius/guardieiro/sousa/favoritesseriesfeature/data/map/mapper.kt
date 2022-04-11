package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.data.map

import br.com.vinicius.guardieiro.sousa.commons.data.database.FavoriteEntity
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.data.FavoriteDomainModel

fun FavoriteEntity.toFavoriteDomainModel() = FavoriteDomainModel(
    id = this.id,
    name = this.name ?: "",
    image = this.imageUrl
)

fun List<FavoriteEntity>.toListOfFavoriteDomainModel(): List<FavoriteDomainModel> {
    val result = arrayListOf<FavoriteDomainModel>()
    this.forEach {
        result.add(it.toFavoriteDomainModel())
    }
    return result
}