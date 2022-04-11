package br.com.vinicius.guardieiro.sousa.detailfeature.domain.model

data class DetailSeriesDomainModel(
    val name: String,
    val id: Long,
    val image: String?,
    val isFavorite : Boolean,
    val episodes : Map<Long, List<DetailEpisodeDomainModel>>,
    val firstEpisodeDate : String?,
    val lastEpisodeDate : String?,
    val timeInAir : String,
    val summary : String,
    val genres : List<String>
)
