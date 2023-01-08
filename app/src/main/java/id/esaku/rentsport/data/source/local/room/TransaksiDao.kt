package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.LapangEntity
import id.esaku.rentsport.data.source.local.entity.RentSportEntity
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaksiDao {
    @Query("SELECT * FROM transaksi WHERE id_user=':id_user'")
    fun getTransaksiFromUser(id_user:String): LiveData<List<TempatSewaEntity>>

    @Query("SELECT * FROM transaksi WHERE id_transaksi=':id_lapang'")
    fun get(id_lapang:String): LiveData<List<TempatSewaEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLapang(lapang:LapangEntity,id_tempat_sewa:String)
}