package id.esaku.rentsport.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket")
data class TicketEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ticket")
    val idTicket: Int,

    @ColumnInfo(name = "id_pegawai")
    val idPegawai: String,

    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: String,

    @ColumnInfo(name = "id_user")
    val idUser: String,

    @ColumnInfo(name = "nama")
    val nama: String,
//
//    @ColumnInfo(name = "tanggal")
//    val tanggal: Date,

    @ColumnInfo(name = "deskripsi")
    val deskripsi: String
)
