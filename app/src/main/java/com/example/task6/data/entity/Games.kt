package com.example.task6.data.entity

import java.io.Serializable

data class Games(
    var game_id: Int,
    var game_name: String,
    var game_resim: String,
    var game_price: String
) : Serializable