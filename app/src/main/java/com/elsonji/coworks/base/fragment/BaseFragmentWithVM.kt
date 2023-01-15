package com.elsonji.coworks.base.fragment

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.elsonji.coworks.extensions.observeNotNull
import com.elsonji.coworks.base.state.BaseState
import com.elsonji.coworks.base.viewmodel.BaseViewModel

abstract class BaseFragmentWithVM<S: BaseState, M: BaseViewModel<S>, VB: ViewBinding> : BaseFragment<VB>() {
    protected abstract val model: M

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeNotNull(model.getState()) { state ->
            onStateChanged(state)
        }
        setupBindings()
    }

    abstract fun setupBindings()
    abstract fun onStateChanged(state: S)
}