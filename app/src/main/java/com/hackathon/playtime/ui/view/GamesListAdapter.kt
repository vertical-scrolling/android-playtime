package com.hackathon.playtime.ui.view

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hackathon.playtime.R
import com.hackathon.playtime.databinding.GameCardBinding
import com.hackathon.playtime.domain.model.GameSummary
import com.hackathon.playtime.utils.bindingInflate
import com.hackathon.playtime.utils.toGlidePath
import kotlinx.coroutines.NonDisposableHandle.parent

class GamesListAdapter(
    private val context: Context?,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<GamesListAdapter.GameHolder>() {

    private var games: List<GameSummary> = emptyList()

    init {
        setHasStableIds(false)
    }

    fun setGames(gamesList: List<GameSummary>) {
        val needRefresh = this.games.size != gamesList.size
        games = gamesList
        if (needRefresh) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeChanged(0, this.games.size)
        }
    }

    override fun getItemCount() = games.size

    override fun getItemId(position: Int): Long =
        games.getOrNull(position)?.gameId?.toLong() ?: 0L

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(parent.bindingInflate(R.layout.game_card, false), context)
    }

    override fun onBindViewHolder(gameHolder: GameHolder, position: Int) {
        gameHolder.bind(games[position])

        Glide.with(gameHolder.getGameImage())
            .load(games[position].imageUrl)
            .placeholder(R.drawable.no_image)
            .into(gameHolder.getGameImage())
    }

    inner class GameHolder(private val binding: GameCardBinding, val context: Context?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gameSummary: GameSummary) {

            binding.apply {
                with(gameSummary){
                    gameCardTextView.text = gameName
                    ratingNumberView.text = gameRating.toString()
                    yearTextView.text = gameReleaseDate.toString()
                    ratingIconView.setImageDrawable(AppCompatResources.getDrawable(binding.root.context,
                        when {
                            (gameRating >= 0.0 && gameRating < 1.0) -> R.drawable.ic_rating_grey
                            (gameRating >= 1.0 && gameRating < 2.0) -> R.drawable.ic_rating_red
                            (gameRating >= 2.0 && gameRating < 3.0) -> R.drawable.ic_rating_orange
                            (gameRating >= 3.0 && gameRating < 4.0) -> R.drawable.ic_rating_yellow
                            (gameRating >= 4.0 && gameRating < 5.0) -> R.drawable.ic_rating_green
                            else -> R.drawable.ic_rating_blue
                        }
                    ))

                    root.setOnClickListener {
                        onItemClick(gameId)
                    }
                }


            }


        }

        fun getGameImage(): ImageView {
            return binding.gameImageView
        }

    }
}