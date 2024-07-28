package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: com.present.pokemon.model.raw.BlackWhite
)