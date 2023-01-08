package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.LapangEntity
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity

@Dao
interface LapangDao {
    @Query("SELECT * FROM lapang WHERE id_lapang=':id_lapang'")
    fun getLapangFromTempatSewa(id_lapang:String): LiveData<List<TempatSewaEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLapang(lapang:LapangEntity,id_tempat_sewa:String)
}