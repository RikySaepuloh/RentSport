package id.esaku.rentsport.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.esaku.rentsport.data.source.local.entity.DetailTransaksiEntity

@Database(entities = [DetailTransaksiEntity::class], version = 1, exportSchema = false)
abstract class DetailTransaksiDatabase : RoomDatabase() {
    abstract fun detailTransaksiDao(): DetailTransaksiDao

    companion object{
        @Volatile
        private var INSTANCE:DetailTransaksiDatabase?=null

        fun getDatabase(context:Context):DetailTransaksiDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,DetailTransaksiDatabase::class.java,"detail_transaksi_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}