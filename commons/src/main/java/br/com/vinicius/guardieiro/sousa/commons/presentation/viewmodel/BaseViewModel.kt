package br.com.vinicius.guardieiro.sousa.commons.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(){

    protected var _loadState: MutableLiveData<Boolean> = MutableLiveData()
    val loadState: LiveData<Boolean>
        get() = _loadState

    init {
        _loadState.postValue(true)
    }

    fun invokeSuspendWithLoad(block : suspend () -> Unit){
        viewModelScope.launch {
            _loadState.value = true
            block.invoke()
            _loadState.value = false
        }
    }
    fun invokeSuspend(block : suspend () -> Unit){
        viewModelScope.launch {
            block.invoke()
        }
    }


}