package br.com.vinicius.guardieiro.sousa.searchfeature.data.map

import br.com.vinicius.guardieiro.sousa.searchfeature.data.network.model.SearchModelNetwork
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.data.SearchSeriesData

fun SearchModelNetwork.toSearchSeriesData() = SearchSeriesData(
    id = this.show.id,
    name = this.show.name,
    image = this.show.image?.original
)

fun List<SearchModelNetwork>.toSearchSeriesData() : List<SearchSeriesData> {
    val result = arrayListOf<SearchSeriesData>()
    this.forEach {
        result.add(it.toSearchSeriesData())
    }
    return result
}