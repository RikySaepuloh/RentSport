package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transaksi")
data class TransaksiEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: String,

    @ColumnInfo(name = "id_user")
    val idUser: String,

    @ColumnInfo(name = "tanggal")
    val tanggal: Date,

    @ColumnInfo(name = "status")
    val status: Boolean
)
