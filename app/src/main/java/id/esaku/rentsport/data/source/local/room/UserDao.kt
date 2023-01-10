package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:UserEntity)

    @Query("UPDATE user SET nama=:nama, email=:email, alamat=:alamat, password=:password WHERE id_user=:userid")
    suspend fun updateUser(userid:Int,nama:String,email:String,alamat:String,password: String)

    @Query("SELECT * FROM user WHERE id_user=:idUser LIMIT 1")
    fun getUserProfile(idUser:Int): UserEntity
//
    @Query("SELECT * FROM user WHERE username=:username AND password=:password LIMIT 1")
    suspend fun login(username:String,password:String): UserEntity

    @Insert
    fun insertNewUser(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}