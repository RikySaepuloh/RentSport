package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_event")
    val idEvent: Int,

    @ColumnInfo(name = "id_user")
    val idUser: String,

    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: String,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "tanggal_event")
    val tanggalEvent: Date,
)
