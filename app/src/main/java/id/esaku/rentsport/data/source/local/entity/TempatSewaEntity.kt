package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tempatSewa")
data class TempatSewaEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_tempat_sewa")
    val idTempatSewa: Int,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "alamat")
    val alamat: String,

    @ColumnInfo(name = "deskripsi")
    val deskripsi: String,

    @ColumnInfo(name = "foto")
    val foto: Int,

    @ColumnInfo(name = "jumlah_lapangan")
    val jumlahLapangan: Int,
)
