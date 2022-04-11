package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model

data class DetailSeriesPresentationModel(
    val name: String,
    val id: Long,
    val image: String?,
    val isFavorite : Boolean,
    val episodes : Map<Long, List<DetailEpisodePresentationModel>>,
    val firstEpisodeDate : String?,
    val lastEpisodeDate : String?,
    val timeInAir : String,
    val summary : String,
    val genres : List<String>
)
