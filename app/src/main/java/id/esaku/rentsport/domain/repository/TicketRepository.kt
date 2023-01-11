package id.esaku.rentsport.domain.repository

import androidx.lifecycle.LiveData
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.TicketDao
import id.esaku.rentsport.data.source.local.room.UserDao

class TicketRepository(
    private val ticketDao: TicketDao
) {
//    val readAllData:LiveData<List<UserEntity>> = ticketDao.getAllUser()
//
//    suspend fun login(username:String, password:String) =
//        userDao.login(username,password)
//
//    suspend fun addUser(user:UserEntity){
//        userDao.addUser(user)
//    }
}
