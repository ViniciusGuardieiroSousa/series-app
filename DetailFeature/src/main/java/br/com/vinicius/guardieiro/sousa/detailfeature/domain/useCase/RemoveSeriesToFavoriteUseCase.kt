package br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel

interface RemoveSeriesToFavoriteUseCase {
    suspend fun invoke(item: DetailSeriesDomainModel)
}