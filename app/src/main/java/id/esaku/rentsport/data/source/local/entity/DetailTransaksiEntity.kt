package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detailTransaksi")
data class DetailTransaksiEntity(
    @PrimaryKey
    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: Int,

    @ColumnInfo(name = "id_lapang")
    val idLapang: Int,

    @ColumnInfo(name = "deskripsi")
    val deskripsi: String,

    @ColumnInfo(name = "harga")
    val harga: Int,

)
