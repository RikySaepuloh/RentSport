package id.esaku.rentsport.domain.repository

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

    suspend fun updateUser(userid: Int,nama:String,email:String,alamat:String,password: String){
        userDao.updateUser(userid,nama, email, alamat, password)
    }

    fun getUser(userid:Int)= userDao.getUserProfile(userid)

}
