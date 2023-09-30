package com.example.task6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task6.data.entity.Games
import com.example.task6.databinding.FeaturedGamesItemBinding

class FeaturedGamesAdapter(var mContext: Context, var gamesList: List<Games>) :
    RecyclerView.Adapter<FeaturedGamesAdapter.FeaturedGamesItem>() {
    inner class FeaturedGamesItem(var tasarim: FeaturedGamesItemBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedGamesItem {
        val binding = FeaturedGamesItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FeaturedGamesItem(binding)
    }

    override fun onBindViewHolder(holder: FeaturedGamesItem, position: Int) {
        val film = gamesList[position]
        val t = holder.tasarim
        t.gameName.text = film.game_name
        if (film.game_price != "Free to Play") {
            t.gamePrice.text = "${film.game_price} TL"
        } else {
            t.gamePrice.text = "Free to Play"
        }
        t.gamePhoto.setImageResource(
            mContext.resources.getIdentifier(
                film.game_resim,
                "drawable",
                mContext.packageName
            )
        )
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}