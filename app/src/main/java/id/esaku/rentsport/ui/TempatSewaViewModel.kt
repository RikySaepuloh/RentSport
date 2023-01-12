package id.esaku.rentsport.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.data.source.TempatSewaRepository
import id.esaku.rentsport.data.source.UserRepository
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.TempatSewaDatabase
import id.esaku.rentsport.data.source.local.room.UserDatabase
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class TempatSewaViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<TempatSewaEntity>>
    private val _tempatSewaData = MutableLiveData<TempatSewaEntity?>()
    val tempatSewa: LiveData<TempatSewaEntity?> get() = _tempatSewaData
//    private val _loginData = MutableLiveData<UserEntity?>()
//    val loginData: LiveData<UserEntity?> get() = _loginData
    private val repository:TempatSewaRepository

    init{
        val tempatSewaDao = TempatSewaDatabase.getDatabase(application).tempatSewaDao()
        repository = TempatSewaRepository(tempatSewaDao)
        readAllData = repository.readAllData
    }
//
    fun getTempatSewa(tempatSewaId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            _tempatSewaData.postValue(repository.getTempatSewa(tempatSewaId))
        }
    }
//
//    fun updateUser(userid:Int,nama:String,email:String,alamat:String,password: String){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.updateUser(userid,nama, email, alamat, password)
//        }
//    }
//
    fun addTempatSewa(tempatSewa:TempatSewaEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTempatSewa(tempatSewa)
        }
    }
//
//    fun login(username:String,password:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            _loginData.postValue(repository.login(username, password))
//        }
//    }


}