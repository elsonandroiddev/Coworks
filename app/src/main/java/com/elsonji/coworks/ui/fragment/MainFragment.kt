package com.elsonji.coworks.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.elsonji.coworks.R
import com.elsonji.coworks.base.fragment.BaseFragmentWithVM
import com.elsonji.coworks.databinding.FragmentMainBinding
import com.elsonji.coworks.ui.state.MainFragmentState
import com.elsonji.coworks.ui.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment :
    BaseFragmentWithVM<MainFragmentState, MainFragmentViewModel, FragmentMainBinding>() {
    override val model: MainFragmentViewModel by viewModels()

    override fun getViewBinding(): FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

    override fun setupView(viewState: Bundle?) {
        lifecycleScope.launch {
            model.getRate()
        }
    }

    override fun setupBindings() {
        binding.refresh.setOnClickListener {
            lifecycleScope.launch {
                model.getRate()
            }
        }
    }

    override fun onStateChanged(state: MainFragmentState) {
        when (state) {
            MainFragmentState.Loading -> {
                binding.loading.visibility = View.VISIBLE
            }
            is MainFragmentState.Success -> {
                binding.loading.visibility = View.GONE
                val rate = state.rate.rate.toString()
                binding.rate.text = getString(R.string.rate_in_usd, rate)
            }
            MainFragmentState.Error -> {
                binding.loading.visibility = View.GONE
                Toast.makeText(context, getString(R.string.error_message), Toast.LENGTH_SHORT)
                    .show()
            }
            MainFragmentState.SuccessWithSameData -> {
                binding.loading.visibility = View.GONE
                Toast.makeText(
                    context,
                    getString(R.string.same_data_warning_text),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}