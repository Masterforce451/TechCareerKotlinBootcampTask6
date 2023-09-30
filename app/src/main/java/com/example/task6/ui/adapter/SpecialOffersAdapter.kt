package com.example.task6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task6.data.entity.SpecialOffers
import com.example.task6.databinding.SpecialOfferItemBinding

class SpecialOffersAdapter(var mContext: Context, var specialOfferList: List<SpecialOffers>): RecyclerView.Adapter<SpecialOffersAdapter.SpecialOfferItem>() {
    val spanDecideList = arrayListOf(2,3,4,5,7,8)
    inner class SpecialOfferItem(var tasarim: SpecialOfferItemBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialOfferItem {
        val binding = SpecialOfferItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SpecialOfferItem(binding)
    }

    override fun onBindViewHolder(holder: SpecialOfferItem, position: Int) {
        val factor: Float = holder.itemView.context.resources.displayMetrics.density
        val offer = specialOfferList[position]
        val t = holder.tasarim
        if (position in spanDecideList) {
            t.gamePhoto.layoutParams.width = (300 * factor).toInt()
            t.gamePhoto.layoutParams.height = (200 * factor).toInt()
        }
        t.gamePhoto.setImageResource(mContext.resources.getIdentifier(offer.photo_id,"drawable",mContext.packageName))
    }

    override fun getItemCount(): Int {
        return specialOfferList.size
    }

}