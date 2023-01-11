package id.esaku.rentsport.domain.repository

import androidx.lifecycle.LiveData
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.TempatSewaDao
import id.esaku.rentsport.data.source.local.room.UserDao

class TempatSewaRepository(
    private val tempatSewaDao: TempatSewaDao
) {
    val readAllData:LiveData<List<TempatSewaEntity>> = tempatSewaDao.getAllTempatSewa()
    fun getTempatSewa(id_tempat_sewa:Int)= tempatSewaDao.getTempatSewa(id_tempat_sewa)

    suspend fun addTempatSewa(tempatSewa:TempatSewaEntity){
        tempatSewaDao.addTempatSewa(tempatSewa)
    }
}
