package com.present.pokemon.model.raw


import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("move")
    val move: com.present.pokemon.model.raw.MoveX,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)