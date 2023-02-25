package com.hackathon.playtime.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hackathon.playtime.BaseFragment
import com.hackathon.playtime.R
import com.hackathon.playtime.databinding.GamesListFragmentBinding
import com.hackathon.playtime.ui.viewmodel.GamesListViewModel
import com.hackathon.playtime.utils.GamesListStatus
import com.hackathon.playtime.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesListFragment : BaseFragment(R.layout.games_list_fragment) {

    private val binding by viewBinding(GamesListFragmentBinding::bind)

    private val viewModel by viewModel<GamesListViewModel>()

    private val haveFiltersLoadedLiveData = MediatorLiveData<Boolean>()

    private val gamesAdapter = GamesListAdapter(context,::goToGameDetails)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        haveFiltersLoadedLiveData.apply {
            fun checkStatus() {
                haveFiltersLoadedLiveData.value =
                    viewModel.getGenresLiveData().value != null &&
                    viewModel.getStoresLiveData().value != null &&
                    viewModel.getPlatformsLiveData().value != null &&
                    (viewModel.getGamesListStatus().value == GamesListStatus.FILTERS_LOADED)
            }

            addSource(viewModel.getGenresLiveData()) {
                checkStatus()
            }

            addSource(viewModel.getPlatformsLiveData()) {
                checkStatus()
            }

            addSource(viewModel.getStoresLiveData()) {
                checkStatus()
            }

            addSource(viewModel.getGamesListStatus()){
                checkStatus()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        haveFiltersLoadedLiveData.distinctUntilChanged().observe(viewLifecycleOwner) {
            if (it) {

            }
        }

        viewModel.getGamesListStatus().observe(viewLifecycleOwner) {
            when (it) {
                GamesListStatus.FILTERS_LOADED -> {
                    //TODO set adapter
                }
                GamesListStatus.GAMES_LOADED -> {
                    //TODO set adapter
                }
                GamesListStatus.INIT -> TODO()
                GamesListStatus.LOADING_FILTERS -> TODO()
                GamesListStatus.LODING_GAMES -> TODO()
                GamesListStatus.ERROR_FILTERS -> TODO()
                GamesListStatus.ERROR_GAMES -> TODO()
            }
        }
        //TODO set adapter

        binding.apply {
            cardViewRecycler.layoutManager = GridLayoutManager(context, 2)
            cardViewRecycler.adapter = gamesAdapter
        }

        viewModel.getGamesLiveData().distinctUntilChanged().observe(viewLifecycleOwner) { gamesList ->
            gamesAdapter.setGames(gamesList)
        }

        viewModel.setUp()
    }

    private fun goToGameDetails(gameId: Int) {
        Log.e("GamesList", "goToGameDetails - gameId: $gameId clicked")
        val action = GamesListFragmentDirections.actionGamesListFragmentToGameDetailsFragment(gameId)
        findNavController().navigateSafe(action)
    }

}