package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.vinicius.guardieiro.sousa.commons.presentation.viewmodel.BaseViewModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesOrderByNameUseCase
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.domain.useCase.GetAllFavoritesSeriesUseCase
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.map.toSearchSeriesModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.model.FavoritePresentationModel
import kotlinx.coroutines.launch

sealed class EitherFavoritePresentationModel {
    data class Left(val message: String, val cause: Exception? = null) :
        EitherFavoritePresentationModel()

    data class Right(val value: List<FavoritePresentationModel>) :
        EitherFavoritePresentationModel()
}

class FavoriteViewModel(
    private val getAllFavoritesSeriesUseCase: GetAllFavoritesSeriesUseCase,
    private val getAllFavoritesSeriesOrderByNameUseCase: GetAllFavoritesSeriesOrderByNameUseCase
) : BaseViewModel() {
    private var _seriesPresentationList: MutableLiveData<EitherFavoritePresentationModel> =
        MutableLiveData()
    val seriesPresentationList: LiveData<EitherFavoritePresentationModel>
        get() = _seriesPresentationList

    init {
        _loadState.postValue(false)
    }

    fun getAllFavorites() {
        viewModelScope.launch {
            invokeSuspendWithLoad{
                try {
                    _seriesPresentationList.value = EitherFavoritePresentationModel.Right(
                        getAllFavoritesSeriesUseCase.invoke().toSearchSeriesModel()
                    )
                } catch (e: Exception) {
                    EitherFavoritePresentationModel.Left(e.message ?: "", e)
                }
            }
        }
    }

    fun getAllFavoritesOrderByName() {
        viewModelScope.launch {
            invokeSuspendWithLoad {
                try {
                    _seriesPresentationList.value = EitherFavoritePresentationModel.Right(
                        getAllFavoritesSeriesOrderByNameUseCase.invoke().toSearchSeriesModel()
                    )
                } catch (e: Exception) {
                    EitherFavoritePresentationModel.Left(e.message ?: "", e)
                }
            }
        }
    }
}