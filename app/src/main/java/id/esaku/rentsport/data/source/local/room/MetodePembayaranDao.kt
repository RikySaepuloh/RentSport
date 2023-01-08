package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.*
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MetodePembayaranDao {
    @Query("SELECT * FROM lapang")
    fun getMetodePembayaran(): LiveData<List<MetodePembayaranEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLapang(lapang:LapangEntity,id_tempat_sewa:String)
}