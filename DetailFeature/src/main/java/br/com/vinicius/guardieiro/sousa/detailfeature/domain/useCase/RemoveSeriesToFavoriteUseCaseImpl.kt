package br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository.DetailSeriesRepository

class RemoveSeriesToFavoriteUseCaseImpl(private val repository: DetailSeriesRepository) :
    RemoveSeriesToFavoriteUseCase {
    override suspend fun invoke(item: DetailSeriesDomainModel) {
        repository.removeFavorite(item)
    }
}