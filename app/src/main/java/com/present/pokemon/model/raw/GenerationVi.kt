package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: com.present.pokemon.model.raw.OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xY: XY
)