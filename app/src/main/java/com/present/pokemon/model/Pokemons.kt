package com.present.pokemon.model


import com.google.gson.annotations.SerializedName

data class Pokemons(
    /*@SerializedName("count")
    val count: Int,

    @SerializedName("previous")
    val previous: Any,*/
    @SerializedName("next")
    val next: String,
    @SerializedName("results")
    val results: List<Result>
)