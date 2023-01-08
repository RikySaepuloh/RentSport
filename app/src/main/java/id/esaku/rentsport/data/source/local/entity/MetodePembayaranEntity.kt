package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "metodePembayaran")
data class MetodePembayaranEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_metode")
    val idMetode: String,

    @ColumnInfo(name = "nama")
    val nama: String,
)
