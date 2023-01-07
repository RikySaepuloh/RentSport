package id.esaku.rentsport.data.source.local

import id.esaku.rentsport.data.source.local.entity.RentSportEntity
import id.esaku.rentsport.data.source.local.room.RecipeDao

class LocalDataSource(private val recipeDao: RecipeDao) {

    fun getAllFavoriteRecipe() =
        recipeDao.getAllFavoriteRecipe()

    suspend fun getFavoriteRecipeById(recipeKey: String) =
        recipeDao.getFavoriteRecipeById(recipeKey)

    suspend fun addRecipeToFavorite(recipe: RentSportEntity) =
        recipeDao.addRecipeToFavorite(recipe)

    suspend fun removeRecipeFromFavorite(recipe: RentSportEntity) =
        recipeDao.removeRecipeFromFavorite(recipe)
}