package br.com.vinicius.guardieiro.sousa.listseries.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.vinicius.guardieiro.sousa.commons.presentation.viewmodel.BaseViewModel
import br.com.vinicius.guardieiro.sousa.listseries.domain.useCase.GetListSeriesUseCase
import br.com.vinicius.guardieiro.sousa.listseries.presentation.map.toListOfListSeriesPresentationModel
import br.com.vinicius.guardieiro.sousa.listseries.presentation.model.ListSeriesPresentationModel

sealed class EitherListSeriesPresentationModel {
    data class Left(val message: String, val cause: Exception? = null) :
        EitherListSeriesPresentationModel()

    data class Right(val value: List<ListSeriesPresentationModel>) :
        EitherListSeriesPresentationModel()
}

class ListSeriesViewModel(private val useCase: GetListSeriesUseCase) : BaseViewModel() {

    private val _series = MutableLiveData<EitherListSeriesPresentationModel>()
    val series: LiveData<EitherListSeriesPresentationModel>
        get() = _series

    fun getNextPage() {
        invokeSuspendWithLoad {
            try {
                val result = useCase.invoke()
                result?.let {
                    _series.value =
                        EitherListSeriesPresentationModel.Right(it.toListOfListSeriesPresentationModel())
                }
            } catch (e: Exception) {
                _series.value =
                    EitherListSeriesPresentationModel.Left(e.message ?: "", e)
            }
        }
    }
}