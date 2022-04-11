package br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model

data class DetailSeriesNetworkModel (
    val id: Long,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val genres: List<String>,
    val status: String,
    val runtime: Long,
    val averageRuntime: Long,
    val premiered: String,
    val ended: String,
    val officialSite: String,
    val schedule: Schedule,
    val rating: Rating,
    val weight: Long,
    val network: Network,
    val webChannel: Any? = null,
    val dvdCountry: Any? = null,
    val externals: Externals,
    val image: Image?,
    val summary: String?,
    val updated: Long,
    val _links: LinksSeries
)

data class Externals (
    val tvrage: Long,
    val thetvdb: Long,
    val imdb: String
)

data class Previousepisode (
    val href: String
)

data class Network (
    val id: Long,
    val name: String,
    val country: Country,
    val officialSite: String
)

data class Country (
    val name: String,
    val code: String,
    val timezone: String
)

data class Schedule (
    val time: String,
    val days: List<String>
)

data class LinksSeries (
    val self: Self,
    val previousepisode: Previousepisode
)
