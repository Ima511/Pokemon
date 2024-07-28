package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("ability")
    val ability: com.present.pokemon.model.raw.AbilityX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)