package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.map

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailEpisodeDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailEpisodePresentationModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailSeriesPresentationModel

fun DetailSeriesDomainModel.toDetailSeriesPresentationModel(): DetailSeriesPresentationModel =
    DetailSeriesPresentationModel(
        name = this.name,
        id = this.id,
        image = this.image,
        isFavorite = this.isFavorite,
        episodes = this.episodes.toMapOfListDetailEpisodePresentationModel(),
        firstEpisodeDate = this.firstEpisodeDate,
        lastEpisodeDate = this.lastEpisodeDate,
        timeInAir = this.timeInAir,
        summary = this.summary,
        genres = this.genres
    )

fun Map<Long, List<DetailEpisodeDomainModel>>.toMapOfListDetailEpisodePresentationModel() = this.mapValues { it.value.toListOfDetailEpisodePresentationModel() }


fun List<DetailEpisodeDomainModel>.toListOfDetailEpisodePresentationModel() : List<DetailEpisodePresentationModel>{
    val result = arrayListOf<DetailEpisodePresentationModel>()
    this.forEach {
        result.add(it.toDetailEpisodePresentationModel())
    }
    return result
}

fun DetailEpisodeDomainModel.toDetailEpisodePresentationModel() = DetailEpisodePresentationModel(
    number = this.number,
    airDate = this.airDate,
    name = this.name,
    summary = this.summary,
)