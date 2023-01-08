package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class LapangEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_lapang")
    val idLapang: String,

    @ColumnInfo(name = "id_tempat_sewa")
    val idTempatSewa: String,

    @ColumnInfo(name = "deskripsi")
    val deskripsi: String,

    @ColumnInfo(name = "harga")
    val harga: Int,
)
