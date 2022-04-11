package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.vinicius.guardieiro.sousa.commons.presentation.viewmodel.BaseViewModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.model.DetailSeriesDomainModel
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase.AddSeriesToFavoriteUseCase
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase.GetSeriesDetailUseCase
import br.com.vinicius.guardieiro.sousa.detailfeature.domain.useCase.RemoveSeriesToFavoriteUseCase
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.map.toDetailSeriesPresentationModel
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.model.DetailSeriesPresentationModel

sealed class EitherPresentationModel {
    data class Left(val message: String, val cause: Exception? = null) : EitherPresentationModel()
    data class Right(val value: DetailSeriesPresentationModel) : EitherPresentationModel()
}

class DetailSeriesViewModel(
    private val getDetailUseCase: GetSeriesDetailUseCase,
    private val addSeriesToFavoriteUseCase: AddSeriesToFavoriteUseCase,
    private val removeSeriesToFavoriteUseCase: RemoveSeriesToFavoriteUseCase
) : BaseViewModel() {

    private var seriesDomain: DetailSeriesDomainModel? = null
    private val _series = MutableLiveData<EitherPresentationModel>()
    val series: LiveData<EitherPresentationModel>
        get() = _series

    var id : Long = 0

    fun getDetail(id: Long) {
        invokeSuspendWithLoad {
            try{
                seriesDomain = getDetailUseCase.invoke(id)
                this@DetailSeriesViewModel.id = id
                seriesDomain?.toDetailSeriesPresentationModel()?.let {
                    _series.value = EitherPresentationModel.Right(it)
                }
            }catch (e : Exception){
                _series.value = EitherPresentationModel.Left(e.message ?: "", e)
            }
        }
    }

    fun addFavorite() {
        invokeSuspend{
            seriesDomain?.let{
                try {
                    addSeriesToFavoriteUseCase.invoke(it)
                }catch (e : Exception){
                    Log.d("add_favorite", e.message.toString())
                }
            }
        }
    }

    fun removeFavorite() {
        invokeSuspend {
            seriesDomain?.let{
                try {
                    removeSeriesToFavoriteUseCase.invoke(it)
                }catch (e : Exception){
                    Log.d("remove_favorite", e.message.toString())
                }
            }
        }
    }
}