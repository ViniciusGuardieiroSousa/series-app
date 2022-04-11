package br.com.vinicius.guardieiro.sousa.detailfeature.data.map

import android.text.Html
import br.com.vinicius.guardieiro.sousa.commons.data.database.FavoriteEntity
import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model.DetailEpisodesNetworkModel
import br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model.DetailSeriesNetworkModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailEpisodeDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import java.text.SimpleDateFormat

const val FORMATTER_DATE = "yyyy-MM-dd"
const val SECONDS = 1000
const val MINUTES = 60
const val HOURS = 60
const val DAYS = 24
const val MOUTHS = 30
const val YEARS = 12


fun DetailSeriesNetworkModel.toDetailSeriesDomainModel(
    isFavorite: Boolean,
    episodesNetworkModel: List<DetailEpisodesNetworkModel>
): DetailSeriesDomainModel {
    val episodes = episodesNetworkModel?.mapEpisodes()
    val firstEpisodeDate = episodes[episodes.keys.first()]?.first()?.airDate
    val lastEpisodeDate = episodes[episodes.keys.last()]?.first()?.airDate
    val firstEpisodeTimestamp = SimpleDateFormat(FORMATTER_DATE)?.parse(firstEpisodeDate)
    val lastEpisodeTimestamp = SimpleDateFormat(FORMATTER_DATE)?.parse(lastEpisodeDate)
    val timeInAir = ((lastEpisodeTimestamp?.time ?: 0) - (firstEpisodeTimestamp?.time ?:0)).toYears()
    val timeInAirString : String
    if(timeInAir <= 1){
        timeInAirString = "$timeInAir year"
    }
    else{
        timeInAirString = "$timeInAir years"
    }
    return DetailSeriesDomainModel(
        id = this.id,
        image = this.image?.original,
        name = this.name,
        isFavorite = isFavorite,
        episodes = episodes,
        firstEpisodeDate = firstEpisodeDate,
        lastEpisodeDate = lastEpisodeDate,
        timeInAir = timeInAirString,
        genres = this.genres,
        summary = Html.fromHtml(this.summary ?: "").toString()
    )
}

fun List<DetailEpisodesNetworkModel>.mapEpisodes(): Map<Long, List<DetailEpisodeDomainModel>> {
    val result = hashMapOf<Long, ArrayList<DetailEpisodeDomainModel>>()
    this.forEach {
        if (result[it.season] == null) {
            result[it.season] = arrayListOf(it.toDetailEpisodeDomainModel())
        } else {
            result[it.season]?.add(it.toDetailEpisodeDomainModel())
        }

    }
    return result
}

fun DetailEpisodesNetworkModel.toDetailEpisodeDomainModel() = DetailEpisodeDomainModel(
    number = this.number,
    airDate = this.airdate,
    name = this.name,
    summary = Html.fromHtml(this.summary ?: "" ).toString(),
    season = this.season
)

private fun Long.toSeconds() = this/ SECONDS

private fun Long.toMinutes() = this.toSeconds()/ MINUTES

private fun Long.toHours() = this.toMinutes()/ HOURS

private fun Long.toDays() = this.toHours()/ DAYS

private fun Long.toMouths() = this.toDays()/ MOUTHS

private fun Long.toYears() = this.toMouths()/ YEARS

fun DetailSeriesDomainModel.toFavoriteEntity() = FavoriteEntity(
    id = this.id,
    name = this.name,
    imageUrl = this.image
)