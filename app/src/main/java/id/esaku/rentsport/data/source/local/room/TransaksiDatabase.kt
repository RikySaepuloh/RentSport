package id.esaku.rentsport.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity

@Database(entities = [TransaksiEntity::class], version = 1, exportSchema = false)
abstract class TransaksiDatabase : RoomDatabase() {
    abstract fun transaksiDao(): TransaksiDao

    companion object{
        @Volatile
        private var INSTANCE:TransaksiDatabase?=null

        fun getDatabase(context:Context):TransaksiDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,TransaksiDatabase::class.java,"transaksi_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}