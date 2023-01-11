package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transaksi")
data class TransaksiEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: Int,

    @ColumnInfo(name = "id_user")
    val idUser: Int,

    @ColumnInfo(name = "tanggal")
    val tanggal: String,

    @ColumnInfo(name = "status")
    val status: Boolean
)
