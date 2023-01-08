package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class PesertaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_event")
    val idEvent: String,

    @ColumnInfo(name = "id_user")
    val idUser: String,

    @ColumnInfo(name = "id_lapangan")
    val idLapangan: String,

)
