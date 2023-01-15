package com.elsonji.coworks.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elsonji.coworks.base.state.BaseState

abstract class BaseViewModel<S: BaseState> : ViewModel() {
    private val liveState = MutableLiveData<S>()

    fun setState(state: S) {
        liveState.value = state
    }

    fun postState(state: S) {
        liveState.postValue(state)
    }

    fun getState(): LiveData<S> = liveState
}