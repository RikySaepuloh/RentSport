package id.esaku.rentsport.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import id.esaku.rentsport.data.source.local.entity.RentSportEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:UserEntity)

    @Query("SELECT * FROM user WHERE id_user=':idUser' LIMIT 1")
    fun getUserProfile(idUser:String): UserItem

    @Query("SELECT * FROM user WHERE username=':username' AND password=':password' LIMIT 1")
    fun login(username:String,password:String): UserItem

    @Insert
    fun insertNewUser(user: UserItem)

    @Delete
    fun delete(user: UserItem)
}