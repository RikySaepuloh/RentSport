package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pemilik")
data class PemilikEntity(
    @PrimaryKey
    @ColumnInfo(name = "id_tempat_sewa")
    val idTempatSewa: String,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "jumlah_lapangan")
    val jumlahLapangan: Int,
)
