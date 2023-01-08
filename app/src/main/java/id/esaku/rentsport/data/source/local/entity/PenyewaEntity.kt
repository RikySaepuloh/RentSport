package id.esaku.rentsport.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class PenyewaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "poin")
    val poin: Int,

)