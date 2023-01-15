package com.elsonji.coworks.base.activity

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.elsonji.coworks.R
import com.elsonji.coworks.databinding.BaseNavigationHostBinding
import com.elsonji.coworks.base.state.BaseState
import com.elsonji.coworks.base.viewmodel.BaseNavigationViewModel

abstract class BaseNavigationHost<S : BaseState, VM : BaseNavigationViewModel<S>, VB : ViewBinding> :
    BaseActivity<S, VM, VB>() {
    private lateinit var navHostFragment: NavHostFragment

    override fun setupView(savedInstanceState: Bundle?) {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        setupNavigation(navHostFragment)
    }

    protected abstract fun setupNavigation(navHostFragment: NavHostFragment)

    override fun getViewBinding(): VB {
        return BaseNavigationHostBinding.inflate(layoutInflater) as VB
    }
}