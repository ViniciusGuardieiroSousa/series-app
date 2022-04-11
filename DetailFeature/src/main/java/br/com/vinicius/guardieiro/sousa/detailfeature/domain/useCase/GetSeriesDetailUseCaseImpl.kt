package br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.repository.DetailSeriesRepository

class GetSeriesDetailUseCaseImpl(private val repository: DetailSeriesRepository) :
    GetSeriesDetailUseCase {
    override suspend fun invoke(id: Long): DetailSeriesDomainModel {
        return repository.getSeriesDetail(id)
    }
}