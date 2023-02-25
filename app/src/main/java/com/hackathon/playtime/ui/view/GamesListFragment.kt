package com.hackathon.playtime.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackathon.playtime.BaseFragment
import com.hackathon.playtime.R
import com.hackathon.playtime.databinding.GamesListFragmentBinding
import com.hackathon.playtime.ui.viewmodel.GamesListViewModel
import com.hackathon.playtime.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesListFragment() : BaseFragment(R.layout.games_list_fragment) {

    private val binding by viewBinding(GamesListFragmentBinding::bind)

    private val viewModel by viewModel<GamesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setUp()
        //TODO set observers

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO set adapter
    }

}