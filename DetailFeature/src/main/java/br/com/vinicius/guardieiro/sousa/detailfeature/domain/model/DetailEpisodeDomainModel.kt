package br.com.vinicius.guardieiro.sousa.detailfeature.domain.model

data class DetailEpisodeDomainModel(
    val number : Long,
    val airDate : String,
    val name : String,
    val summary : String,
    val season : Long
)