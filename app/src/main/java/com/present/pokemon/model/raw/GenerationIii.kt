package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class GenerationIii(
    @SerializedName("emerald")
    val emerald: com.present.pokemon.model.raw.Emerald,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: com.present.pokemon.model.raw.FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire
)