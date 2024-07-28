package com.present.pokemon.network

import com.present.pokemon.model.PokemonDetails
import com.present.pokemon.model.Pokemons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface PokemonApi {

    @GET("https://pokeapi.co/api/v2/pokemon")
    suspend fun getPokemons(): Response<Pokemons>


    @GET("https://pokeapi.co/api/v2/pokemon/{id}/")
    suspend fun getPokemonsDetail(@Path("id") id: String):Response<PokemonDetails>
}