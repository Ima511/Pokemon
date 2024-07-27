package com.present.pokemon.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.present.pokemon.repository.PokemonsRepository
import retrofit2.HttpException
import java.io.IOException
import com.present.pokemon.model.Result


/*
class PokemonPagingSource(
    private val repository: PokemonsRepository
) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: 0
        val offset = page * params.loadSize
        return try {
            val response = repository.getPokemons(offset, params.loadSize)
            LoadResult.Page(
                data = response.data!!.results,
                prevKey = if (page == 0) null else page - 1,
                nextKey = page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }
}
*/
