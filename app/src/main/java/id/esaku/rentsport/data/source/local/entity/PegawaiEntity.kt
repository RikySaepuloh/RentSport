package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pegawai")
data class PegawaiEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_pegawai")
    val idPegawai: Int,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "alamat")
    val alamat: String,

    @ColumnInfo(name = "jabatan")
    val jabatan: String
)
