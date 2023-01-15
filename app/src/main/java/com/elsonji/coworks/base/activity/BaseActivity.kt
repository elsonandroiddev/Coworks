package com.elsonji.coworks.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.elsonji.coworks.base.state.BaseState
import com.elsonji.coworks.base.viewmodel.BaseViewModel

abstract class BaseActivity<S : BaseState, VM : BaseViewModel<S>, VB : ViewBinding> :
    AppCompatActivity() {
    lateinit var viewModel: VM
    lateinit var binding: VB

    abstract val viewModelClass: Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[viewModelClass]
        binding = getViewBinding()
        setContentView(binding.root)
        setupView(savedInstanceState)
    }

    /**
     * Provides the required view binding, for example, of an activity.
     */
    protected abstract fun getViewBinding(): VB

    /**
     * For setting up initial state of the screen, reading intent params, setting up click listeners, etc.
     */
    protected abstract fun setupView(savedInstanceState: Bundle?)
}