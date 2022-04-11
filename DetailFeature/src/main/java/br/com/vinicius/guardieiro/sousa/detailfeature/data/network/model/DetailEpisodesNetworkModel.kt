package br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model

data class DetailEpisodesNetworkModel (
    val id: Long,
    val url: String,
    val name: String,
    val season: Long,
    val number: Long,
    val type: String,
    val airdate: String,
    val airtime: String,
    val airstamp: String,
    val runtime: Long,
    val rating: Rating,
    val image: Image?,
    val summary: String?,
    val _links: Links
)

data class Self (
    val href: String
)

data class Links (
    val self: Self
)
