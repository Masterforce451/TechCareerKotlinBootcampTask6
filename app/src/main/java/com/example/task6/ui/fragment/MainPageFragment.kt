package com.example.task6.ui.fragment

import android.graphics.Color.rgb
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.color
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.task6.data.entity.Category
import com.example.task6.data.entity.Games
import com.example.task6.data.entity.SpecialOffers
import com.example.task6.databinding.FragmentMainPageBinding
import com.example.task6.ui.adapter.CategoriesAdapter
import com.example.task6.ui.adapter.FeaturedGamesAdapter
import com.example.task6.ui.adapter.SpecialOffersAdapter

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.recyclerViewFeatured.layoutManager =
            GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        val gameList = ArrayList<Games>()
        val game1 = Games(1, "Elder Scrolls Online", "elderscrollsonline", "179,00")
        val game2 = Games(2, "Hogwarts Legacy", "hogwartslegacy", "1.099,00")
        val game3 = Games(3, "Mortal Kombat 1", "mortalkombat1", "1.199,00")
        val game4 = Games(4, "Sunkenland", "sunkenland", "190,00")
        val game5 =
            Games(5, "Call of Duty: Modern Warfare", "callofdutymodernwarfare", "Free to Play")
        val game6 = Games(6, "Wayfinder", "wayfinder", "112,00")
        val game7 = Games(7, "PUGB Battlegrounds", "pugbbattlegrounds", "Free to Play")
        val game8 = Games(8, "Runescape", "runescape", "Free to Play")
        val game9 = Games(9, "Football Manager 2024", "footballmanager2024", "899,00")

        gameList.add(game1)
        gameList.add(game2)
        gameList.add(game3)
        gameList.add(game4)
        gameList.add(game5)
        gameList.add(game6)
        gameList.add(game7)
        gameList.add(game8)
        gameList.add(game9)

        val featuredGamesAdapter = FeaturedGamesAdapter(requireContext(), gameList)
        binding.recyclerViewFeatured.adapter = featuredGamesAdapter

        val spanDecideList = arrayListOf(2, 3, 4, 5, 7, 8)
        binding.recyclerViewSpecials.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
        (binding.recyclerViewSpecials.layoutManager as GridLayoutManager).spanSizeLookup =
            object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position !in spanDecideList) 2 else 1
                }
            }

        val specialOffersList = ArrayList<SpecialOffers>()
        val specialOffer1 = SpecialOffers(0, "unrailed_big")
        val specialOffer2 = SpecialOffers(1, "aspyr_big")
        val specialOffer3 = SpecialOffers(2, "parkasaurus_small")
        val specialOffer4 = SpecialOffers(3, "wolong_small")
        val specialOffer5 = SpecialOffers(4, "astroneer_small")
        val specialOffer6 = SpecialOffers(5, "grounded_small")
        val specialOffer7 = SpecialOffers(6, "realmsdeep_big")
        val specialOffer8 = SpecialOffers(7, "stellrising_small")
        val specialOffer9 = SpecialOffers(8, "tinytinaswonderlands_small")

        specialOffersList.add(specialOffer1)
        specialOffersList.add(specialOffer2)
        specialOffersList.add(specialOffer3)
        specialOffersList.add(specialOffer4)
        specialOffersList.add(specialOffer5)
        specialOffersList.add(specialOffer6)
        specialOffersList.add(specialOffer7)
        specialOffersList.add(specialOffer8)
        specialOffersList.add(specialOffer9)

        val specialOfferAdapter = SpecialOffersAdapter(requireContext(), specialOffersList)
        binding.recyclerViewSpecials.adapter = specialOfferAdapter


        binding.recyclerViewCategory.layoutManager =
            GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        val categoryList = ArrayList<Category>()

        val category1 = Category(0, "anime")
        val category2 = Category(1, "action")
        val category3 = Category(2, "freetoplay")
        val category4 = Category(3, "survival")
        val category5 = Category(4, "exploration_open_world")
        val category6 = Category(5, "strategy_cities_settlements")
        val category7 = Category(6, "adventure")
        val category8 = Category(7, "multiplayer_coop")
        val category9 = Category(8, "visual_novel")

        categoryList.add(category1)
        categoryList.add(category2)
        categoryList.add(category3)
        categoryList.add(category4)
        categoryList.add(category5)
        categoryList.add(category6)
        categoryList.add(category7)
        categoryList.add(category8)
        categoryList.add(category9)

        val categoryAdapter = CategoriesAdapter(requireContext(), categoryList)
        binding.recyclerViewCategory.adapter = categoryAdapter

        val button = binding.toolbar.button3
        button.text = SpannableStringBuilder()
            .append("WALLET ")
            .color(rgb(28, 116, 180)) { append("(0,00 TL)") }


        return binding.root
    }

}