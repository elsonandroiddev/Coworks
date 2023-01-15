package com.elsonji.coworks.navigation

import androidx.navigation.fragment.NavHostFragment
import com.elsonji.coworks.R
import com.elsonji.coworks.base.activity.BaseNavigationHost
import com.elsonji.coworks.base.state.BaseState
import com.elsonji.coworks.databinding.BaseNavigationHostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainNavHost : BaseNavigationHost<BaseState, MainNavHostViewModel, BaseNavigationHostBinding>() {

    override val viewModelClass: Class<MainNavHostViewModel>
        get() = MainNavHostViewModel::class.java

    override fun setupNavigation(navHostFragment: NavHostFragment) {
        navHostFragment.navController.setGraph(R.navigation.nav_graph_main)
    }
}