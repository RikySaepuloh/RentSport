package id.esaku.rentsport.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.esaku.rentsport.data.source.local.entity.TicketEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity

@Database(entities = [TicketEntity::class], version = 1, exportSchema = false)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao

    companion object{
        @Volatile
        private var INSTANCE:TicketDatabase?=null

        fun getDatabase(context:Context):TicketDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,TicketDatabase::class.java,"ticket_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}