package id.esaku.rentsport.domain.repository

import androidx.lifecycle.LiveData
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.TransaksiDao
import id.esaku.rentsport.data.source.local.room.UserDao

class TransaksiRepository(
    private val transaksiDao: TransaksiDao
) {

    fun getTransaksi(idUser:Int) = transaksiDao.getTransaksiFromUser(idUser)

    suspend fun addTransaksi(transaksi:TransaksiEntity):Long{
        return transaksiDao.addTransaksi(transaksi)
    }
//
//    suspend fun updateUser(userid: Int,nama:String,email:String,alamat:String,password: String){
//        userDao.updateUser(userid,nama, email, alamat, password)
//    }
//
//    suspend fun getUser(userid:Int)= userDao.getUserProfile(userid)

}
