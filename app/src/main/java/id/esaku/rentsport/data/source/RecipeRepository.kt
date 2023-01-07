package id.esaku.rentsport.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import id.esaku.rentsport.data.source.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepository(
    private val localDataSource: LocalDataSource,
) : IRecipeRepository {
    override fun getTodayPicks(): Flow<Resource<List<RecipeItem>>> =
        object : NetworkBoundResource<List<RecipeItem>, List<RecipeItemResponse>>() {
            override fun convertDataToDomainModel(data: List<RecipeItemResponse>): List<RecipeItem> {
                return data.map {
                    it.toDomainModel()
                }
            }

            override suspend fun getDataFromNetwork(): Flow<ApiResponse<List<RecipeItemResponse>>> {
               return remoteDataSource.getTodayPicks()
            }

        }.asFlow()

    override fun getListRecipe(): Flow<PagingData<RecipeItem>> =
        Pager(
            config = PagingConfig(PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { remoteDataSource.RecipePagingSource() }
        ).flow.map {
            it.map { recipeItemResponse ->
                recipeItemResponse.toDomainModel()
            }
        }


    override fun getDetailRecipe(recipeKey: String): Flow<Resource<DetailRecipe>> =
        object : NetworkBoundResource<DetailRecipe, DetailRecipeResponse>() {
            override fun convertDataToDomainModel(data: DetailRecipeResponse): DetailRecipe =
                data.toDomainModel()


            override suspend fun getDataFromNetwork(): Flow<ApiResponse<DetailRecipeResponse>> =
                remoteDataSource.getDetailRecipe(recipeKey)


        }.asFlow()

    override fun getAllFavoriteRecipe(): Flow<List<RecipeItem>> {
        return localDataSource.getAllFavoriteRecipe().map {
            it.map { recipeEntity ->
                recipeEntity.toDomainModel()
            }
        }
    }

    override suspend fun addRecipeToFavorite(recipe: RecipeItem) {
        val recipeEntity: RecipeEntity = recipe.toEntityModel()
        return localDataSource.addRecipeToFavorite(recipeEntity)

    }

    override suspend fun getFavoriteRecipeById(recipeKey: String): RecipeItem? {
        return localDataSource.getFavoriteRecipeById(recipeKey)
    }

    override suspend fun removeRecipeFromFavorite(recipe: RecipeItem) {
        val recipeEntity: RecipeEntity = recipe.toEntityModel()
        return localDataSource.removeRecipeFromFavorite(recipeEntity)
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}
