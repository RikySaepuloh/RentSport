package id.esaku.rentsport.data.source

import androidx.lifecycle.LiveData
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.UserDao

class UserRepository(
    private val userDao: UserDao
) {
    val readAllData:LiveData<List<UserEntity>> = userDao.getAllUser()

    suspend fun login(username:String, password:String) =
        userDao.login(username,password)

    suspend fun addUser(user:UserEntity){
        userDao.addUser(user)
    }
}
