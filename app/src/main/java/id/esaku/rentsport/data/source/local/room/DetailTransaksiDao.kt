package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.DetailTransaksiEntity
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity

@Dao
interface DetailTransaksiDao {
    @Query("SELECT * FROM detailTransaksi WHERE id_transaksi=:idTransaksi")
    fun getDetailTransaksi(idTransaksi:Int): DetailTransaksiEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDetailTransaksi(detail:DetailTransaksiEntity):Long

}