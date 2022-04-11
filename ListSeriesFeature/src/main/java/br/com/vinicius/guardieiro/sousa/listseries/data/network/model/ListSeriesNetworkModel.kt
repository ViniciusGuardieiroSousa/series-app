package br.com.vinicius.guardieiro.sousa.listseries.data.network.model

import androidx.annotation.Keep

@Keep
data class ListSeriesNetworkModel (
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
    val image: Image?,
    val summary: String,
    val updated: Long,
    val _links: Links
)

@Keep
data class Externals (
    val tvrage: Long,
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
    val self: Nextepisode,
    val previousepisode: Nextepisode? = null,
    val nextepisode: Nextepisode? = null
)

@Keep
data class Nextepisode (
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
