package id.esaku.rentsport.data.source.local.room

import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.RentSportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<RentSportEntity>>

    @Query("SELECT * FROM ticket")
    suspend fun getAllTicket(recipeKey: String)

    @Query("SELECT * FROM pegawai")
    suspend fun getAllPegawai(recipeKey: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipeToFavorite(recipe: RentSportEntity)

    @Delete
    suspend fun removeRecipeFromFavorite(recipe: RentSportEntity)
}