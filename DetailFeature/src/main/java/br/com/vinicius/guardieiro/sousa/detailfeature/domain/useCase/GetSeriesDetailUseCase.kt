package br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase

import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel

interface GetSeriesDetailUseCase {
    suspend fun invoke(id : Long): DetailSeriesDomainModel
}