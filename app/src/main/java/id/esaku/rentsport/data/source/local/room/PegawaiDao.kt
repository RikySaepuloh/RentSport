package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.*
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PegawaiDao {
    @Query("SELECT * FROM pegawai ")
    fun getAllPegawai(): LiveData<List<PegawaiEntity>>

    @Query("SELECT * FROM pegawai WHERE id_pegawai=:id_pegawai")
    fun getPegawaiFromId(id_pegawai:String): LiveData<List<PegawaiEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLapang(lapang:LapangEntity,id_tempat_sewa:String)
}