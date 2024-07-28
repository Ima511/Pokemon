package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class GenerationIi(
    @SerializedName("crystal")
    val crystal: com.present.pokemon.model.raw.Crystal,
    @SerializedName("gold")
    val gold: com.present.pokemon.model.raw.Gold,
    @SerializedName("silver")
    val silver: Silver
)