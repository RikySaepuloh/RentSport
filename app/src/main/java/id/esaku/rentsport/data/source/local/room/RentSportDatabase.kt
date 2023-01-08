package id.esaku.rentsport.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.esaku.rentsport.data.source.local.entity.RentSportEntity

@Database(entities = [RentSportEntity::class], version = 1, exportSchema = false)
abstract class RentSportDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}