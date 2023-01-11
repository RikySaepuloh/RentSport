package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.*
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaksiDao {
    @Query("SELECT * FROM transaksi WHERE id_user=:id_user")
    fun getTransaksiFromUser(id_user:Int): List<TransaksiEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTransaksi(transaksiEntity: TransaksiEntity):Long
}