package com.hackathon.playtime.ui.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import com.hackathon.playtime.BaseFragment
import com.hackathon.playtime.R
import com.hackathon.playtime.databinding.SplashFragmentBinding
import com.hackathon.playtime.utils.viewBinding

class SplashFragment: BaseFragment(R.layout.splash_fragment) {

    private val binding by viewBinding(SplashFragmentBinding::bind)

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToGamesListFragment()
        }, 500)
    }

    private fun navigateToGamesListFragment() {
        findNavController().navigateSafe(
            SplashFragmentDirections.actionSplashFragmentToGamesListFragment()
        )
    }
}