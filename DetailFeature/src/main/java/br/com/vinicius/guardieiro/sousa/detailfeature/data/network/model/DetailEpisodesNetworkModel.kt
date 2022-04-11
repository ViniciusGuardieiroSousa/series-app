package br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model

import androidx.annotation.Keep

@Keep
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

@Keep
data class Self (
    val href: String
)

@Keep
data class Links (
    val self: Self
)
