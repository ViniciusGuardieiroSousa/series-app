package br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository.DetailSeriesRepository

class AddSeriesToFavoriteUseCaseImpl(private val repository: DetailSeriesRepository) : AddSeriesToFavoriteUseCase {
    override suspend fun invoke(item: DetailSeriesDomainModel) {
        repository.addFavorite(item)
    }
}