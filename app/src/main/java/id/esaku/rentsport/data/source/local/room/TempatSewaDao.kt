package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.RentSportEntity
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TempatSewaDao {
    @Query("SELECT * FROM tempatsewa")
    fun getAllTempatSewa(): LiveData<List<TempatSewaEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTempatSewa(tempat_sewa:TempatSewaEntity)


}