package com.example.task6.ui.adapter

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.task6.R
import com.example.task6.data.entity.Category
import com.example.task6.databinding.CategoryItemBinding

class CategoriesAdapter(var mContext: Context, var categoryList: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.FeaturedGamesItem>() {
    inner class FeaturedGamesItem(var tasarim: CategoryItemBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedGamesItem {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FeaturedGamesItem(binding)
    }

    private val layerListDrawable =
        ContextCompat.getDrawable(mContext, R.drawable.category_background) as LayerDrawable

    override fun onBindViewHolder(holder: FeaturedGamesItem, position: Int) {
        val category = categoryList[position]
        val t = holder.tasarim
        t.categoryPhoto.setImageResource(
            mContext.resources.getIdentifier(
                category.photo_id,
                "drawable",
                mContext.packageName
            )
        )
        when (category.photo_id) {
            "anime" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.anime_foreground)
                t.categoryName.text = "ANIME"
            }

            "action" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.action_foreground)
                t.categoryName.text = "ACTION"
            }

            "freetoplay" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.freetoplay_foreground)
                t.categoryName.text = "FREE TO PLAY"
            }

            "survival" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.survival_foreground)
                t.categoryName.text = "SURVIVAL"
            }

            "exploration_open_world" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.exploration_open_world_foreground)
                t.categoryName.text = "OPEN WORLD"
            }

            "strategy_cities_settlements" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.strategy_cities_settlements_foreground)
                t.categoryName.text = "CITY & SETTLEMENT"
            }

            "adventure" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.adventure_foreground)
                t.categoryName.text = "ADVENTURE"
            }

            "multiplayer_coop" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.multiplayer_coop_foreground)
                t.categoryName.text = "CO-OPERATIVE"
            }

            "visual_novel" -> {
                t.categoryPhoto.foreground =
                    layerListDrawable.findDrawableByLayerId(R.id.visual_novel_foreground)
                t.categoryName.text = "VISUAL NOVEL"
            }
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}