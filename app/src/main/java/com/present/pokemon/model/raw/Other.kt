package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: com.present.pokemon.model.raw.DreamWorld,
    @SerializedName("home")
    val home: com.present.pokemon.model.raw.Home,
    @SerializedName("official-artwork")
    val officialArtwork: com.present.pokemon.model.raw.OfficialArtwork,
    @SerializedName("showdown")
    val showdown: Showdown
)