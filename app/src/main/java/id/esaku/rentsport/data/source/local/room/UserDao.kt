package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user:UserEntity)

    @Query("SELECT * FROM user WHERE id_user=:idUser LIMIT 1")
    fun getUserProfile(idUser:String): UserEntity
//
    @Query("SELECT * FROM user WHERE username=:username AND password=:password LIMIT 1")
    suspend fun login(username:String,password:String): UserEntity

    @Insert
    fun insertNewUser(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}