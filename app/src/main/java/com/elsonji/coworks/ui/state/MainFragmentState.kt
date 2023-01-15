package com.elsonji.coworks.ui.state

import com.elsonji.coworks.api.models.Rate
import com.elsonji.coworks.base.state.BaseState

sealed class MainFragmentState : BaseState {
    object Loading : MainFragmentState()
    data class Success(val rate: Rate) : MainFragmentState()
    object Error : MainFragmentState()
    object SuccessWithSameData : MainFragmentState()
}