package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "detailEvent")
data class DetailEventEntity(
    @PrimaryKey
    @ColumnInfo(name = "id_event")
    val idEvent: String,

    @ColumnInfo(name = "id_lapangan")
    val idLapangan: String
)
