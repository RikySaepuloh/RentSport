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
