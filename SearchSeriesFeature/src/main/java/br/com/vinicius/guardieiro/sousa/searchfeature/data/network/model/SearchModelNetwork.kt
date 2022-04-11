package br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model

import androidx.annotation.Keep

@Keep
data class SearchModelNetwork (
    val score: Double,
    val show: Show
)

@Keep
data class Show (
    val id: Long,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val genres: List<String>,
    val status: String,
    val runtime: Long? = null,
    val averageRuntime: Long? = null,
    val premiered: String? = null,
    val ended: String? = null,
    val officialSite: String? = null,
    val schedule: Schedule,
    val rating: Rating,
    val weight: Long,
    val network: Network? = null,
    val webChannel: Network? = null,
    val dvdCountry: Any? = null,
    val externals: Externals,
    val image: Image? = null,
    val summary: String? = null,
    val updated: Long,
    val _links: Links
)

@Keep
data class Externals (
    val tvrage: Long? = null,
    val thetvdb: Long? = null,
    val imdb: String? = null
)

@Keep
data class Image (
    val medium: String,
    val original: String
)

@Keep
data class Links (
    val self: NextEpisode,
    val previousepisode: NextEpisode? = null,
    val nextepisode: NextEpisode? = null
)

@Keep
data class NextEpisode (
    val href: String
)

@Keep
data class Network (
    val id: Long,
    val name: String,
    val country: Country? = null,
    val officialSite: String? = null
)

@Keep
data class Country (
    val name: String,
    val code: String,
    val timezone: String
)

@Keep
data class Rating (
    val average: Double? = null
)

@Keep
data class Schedule (
    val time: String,
    val days: List<String>
)

