package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.vinicius.guardieiro.sousa.commons.presentation.viewmodel.BaseViewModel
import br.com.vinicius.guardieiro.sousa.searchfeature.domain.useCase.GetSeriesByNameUseCase
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.map.toSearchSeriesModel
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.model.SearchSeriesPresentationModel

sealed class EitherSearchSeriesModel {
    data class Left(val message: String, val cause: Exception? = null) :
        EitherSearchSeriesModel()

    data class Right(val value: List<SearchSeriesPresentationModel>) :
        EitherSearchSeriesModel()
}

class SearchViewModel(
    private val getSeriesByNameUseCase: GetSeriesByNameUseCase
) : BaseViewModel() {
    private var _seriesPresentationList: MutableLiveData<EitherSearchSeriesModel> =
        MutableLiveData()
    val seriesPresentationList: LiveData<EitherSearchSeriesModel>
        get() = _seriesPresentationList
    init {
        _loadState.postValue(false)
    }

    fun searchSeriesByName(name: String) {
        invokeSuspendWithLoad {
            try {
                _seriesPresentationList.value = EitherSearchSeriesModel.Right(
                    getSeriesByNameUseCase.invoke(name).toSearchSeriesModel()
                )
            } catch (e: Exception) {
                EitherSearchSeriesModel.Left(e.message ?: "", e)
            }
        }
    }
}