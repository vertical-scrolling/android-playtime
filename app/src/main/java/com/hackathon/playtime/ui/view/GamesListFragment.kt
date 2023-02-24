package com.hackathon.playtime.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackathon.playtime.R
import com.hackathon.playtime.ui.viewmodel.GamesListViewModel

class GamesListFragment : Fragment() {

    companion object {
        fun newInstance() = GamesListFragment()
    }

    private lateinit var viewModel: GamesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GamesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.games_fragment, container, false)
    }

}