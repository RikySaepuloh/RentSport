package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.*
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface DetailEventDao {
    @Query("SELECT * FROM lapang WHERE id_lapang=':id_lapang'")
    fun getLapangFromTempatSewa(id_lapang:String): LiveData<List<TempatSewaEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLapang(lapang:LapangEntity,id_tempat_sewa:String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(event:EventEntity,id_event:String)
}