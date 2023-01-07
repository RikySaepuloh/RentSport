package id.esaku.rentsport.domain.repository

import androidx.paging.PagingData
import id.esaku.rentsport.data.source.Resource
import kotlinx.coroutines.flow.Flow

interface IRecipeRepository {
    fun getTodayPicks(): Flow<Resource<List<RecipeItem>>>

    fun getListRecipe(): Flow<PagingData<RecipeItem>>

    fun getDetailRecipe(recipeKey: String): Flow<Resource<DetailRecipe>>

    fun getAllFavoriteRecipe(): Flow<List<RecipeItem>>

    suspend fun getFavoriteRecipeById(recipeKey: String): RecipeItem?

    suspend fun addRecipeToFavorite(recipe: RecipeItem)

    suspend fun removeRecipeFromFavorite(recipe: RecipeItem)
}