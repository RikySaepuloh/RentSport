package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class RentSportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_user")
    val idUser: String,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "alamat")
    val alamat: String,

    @ColumnInfo(name = "password")
    val password: String
)

@Entity(tableName = "tempat_sewa")
data class TempatSewaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_tempat_sewa")
    val idTempatSewa: String,

    @ColumnInfo(name = "nama")
    val nama: String,

    @ColumnInfo(name = "jumlah_lapangan")
    val jumlahLapangan: Int
)


@Entity(tableName = "transaksi")
data class TransaksiEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_transaksi")
    val idTransaksi: String,

    @ColumnInfo(name = "id_user")
    val id_user: String,

    @ColumnInfo(name = "jumlah_lapangan")
    val jumlahLapangan: Int
)


