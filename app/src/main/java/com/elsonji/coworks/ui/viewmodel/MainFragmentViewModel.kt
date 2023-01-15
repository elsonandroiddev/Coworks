package com.elsonji.coworks.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.elsonji.coworks.base.viewmodel.BaseViewModel
import com.elsonji.coworks.repository.Repository
import com.elsonji.coworks.ui.state.MainFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel<MainFragmentState>() {

    private var lastRate: Double? = null

    suspend fun getRate() {
        postState(MainFragmentState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            delay(3_000)

            try {
                val result = repository.getRateList()
                if (result.isSuccessful) {
                    val rateInUsd = result.body()?.find { it.code == USD_CODE }
                    rateInUsd?.let {
                        if (lastRate == it.rate) {
                            postState(MainFragmentState.SuccessWithSameData)
                        } else {
                            lastRate = it.rate
                            postState(MainFragmentState.Success(it))
                        }
                    }
                } else {
                    postState(MainFragmentState.Error)
                }
            } catch (e: Throwable) {
                postState(MainFragmentState.Error)
            }
        }
    }

    companion object {
        private const val USD_CODE = "USD"
    }
}