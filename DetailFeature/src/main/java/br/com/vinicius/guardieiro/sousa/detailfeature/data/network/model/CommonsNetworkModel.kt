package br.com.vinicius.guardieiro.sousa.detailfeature.data.network.model

import androidx.annotation.Keep

@Keep
data class Image (
    val medium: String,
    val original: String
)

@Keep
data class Rating (
    val average: Double
)