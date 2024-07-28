package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: com.present.pokemon.model.raw.DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: com.present.pokemon.model.raw.HeartgoldSoulsilver,
    @SerializedName("platinum")
    val platinum: com.present.pokemon.model.raw.Platinum
)