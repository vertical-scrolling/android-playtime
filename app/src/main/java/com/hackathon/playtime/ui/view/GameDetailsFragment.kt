package com.hackathon.playtime.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.hackathon.playtime.BaseFragment
import com.hackathon.playtime.R
import com.hackathon.playtime.databinding.GameDetailsFragmentBinding
import com.hackathon.playtime.ui.viewmodel.GameDetailsViewModel
import com.hackathon.playtime.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailsFragment : BaseFragment(R.layout.game_details_fragment) {

    private val binding by viewBinding(GameDetailsFragmentBinding::bind)

    private val viewModel by viewModel<GameDetailsViewModel>()

    private val args: GameDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getGameDetails().observe(viewLifecycleOwner) { gameDetails ->

            binding.apply {
                Glide.with(this@GameDetailsFragment)
                    .load(gameDetails.imageUrl)
                    .placeholder(R.drawable.no_image)
                    .into(gameDetailsImage)
                gameNameDetails.text = gameDetails.gameName
                synopsisText.text = gameDetails.gameSynopsis
                val rating = gameDetails.gameRating
                ratingIcon.setImageDrawable(AppCompatResources.getDrawable(binding.root.context,
                        when {
                            (rating >= 0.0 && rating < 1.0) -> R.drawable.ic_rating_grey
                            (rating >= 1.0 && rating < 2.0) -> R.drawable.ic_rating_red
                            (rating >= 2.0 && rating < 3.0) -> R.drawable.ic_rating_orange
                            (rating >= 3.0 && rating < 4.0) -> R.drawable.ic_rating_yellow
                            (rating >= 4.0 && rating < 5.0) -> R.drawable.ic_rating_green
                            else -> R.drawable.ic_rating_blue
                        }
                ))
                ratingNumber.text = rating.toString()
                dateNumber.text = gameDetails.gameReleaseDate
                playtimeNumber.text = "${gameDetails.gamePlaytime}h"

            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.poweredByText.setOnClickListener {
            val url = "https://rawg.io"
            startActivity(Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) })
        }

        viewModel.setUp(args.gameId)
    }
}