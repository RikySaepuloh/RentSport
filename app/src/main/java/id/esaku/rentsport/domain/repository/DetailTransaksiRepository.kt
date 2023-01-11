package id.esaku.rentsport.domain.repository

import androidx.lifecycle.LiveData
import id.esaku.rentsport.data.source.local.entity.DetailTransaksiEntity
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.DetailTransaksiDao
import id.esaku.rentsport.data.source.local.room.TransaksiDao
import id.esaku.rentsport.data.source.local.room.UserDao

class DetailTransaksiRepository(
    private val detailTransaksiDao: DetailTransaksiDao
) {

    fun getDetailTransaksi(idTransaksi:Int) = detailTransaksiDao.getDetailTransaksi(idTransaksi)

    suspend fun addDetailTransaksi(transaksi:DetailTransaksiEntity){
        detailTransaksiDao.addDetailTransaksi(transaksi)
    }
//
//    suspend fun updateUser(userid: Int,nama:String,email:String,alamat:String,password: String){
//        userDao.updateUser(userid,nama, email, alamat, password)
//    }
//
//    suspend fun getUser(userid:Int)= userDao.getUserProfile(userid)

}
