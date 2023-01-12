package id.esaku.rentsport.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity

@Database(entities = [TempatSewaEntity::class], version = 1, exportSchema = false)
abstract class TempatSewaDatabase : RoomDatabase() {
    abstract fun tempatSewaDao(): TempatSewaDao

    companion object{
        @Volatile
        private var INSTANCE:TempatSewaDatabase?=null

        fun getDatabase(context:Context):TempatSewaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,TempatSewaDatabase::class.java,"tempat_sewa_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}