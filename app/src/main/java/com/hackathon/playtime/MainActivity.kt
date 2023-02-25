package com.hackathon.playtime

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.hackathon.playtime.databinding.MainActivityBinding
import com.hackathon.playtime.ui.view.GamesListFragment
import com.hackathon.playtime.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(MainActivityBinding::inflate)

    override fun onStart() {
        super.onStart()
        binding.navHostFragment.findNavController()
    }

    override fun onPause() {
        super.onPause()
        binding.navHostFragment.findNavController()
    }

}