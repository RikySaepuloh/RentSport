package id.esaku.rentsport.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.domain.repository.TransaksiRepository
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.data.source.local.room.TransaksiDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransaksiViewModel(application: Application):AndroidViewModel(application) {
//    val readAllData: LiveData<List<TransaksiEntity>>
    private val _transaksiData = MutableLiveData<List<TransaksiEntity?>>()
    val transaksiData: LiveData<List<TransaksiEntity?>> get() = _transaksiData
//    private val _loginData = MutableLiveData<UserEntity?>()
//    val loginData: LiveData<UserEntity?> get() = _loginData
    private val repository: TransaksiRepository

    init{
        val transaksiDao = TransaksiDatabase.getDatabase(application).transaksiDao()
        repository = TransaksiRepository(transaksiDao)
//        readAllData = repository.getTransaksi()
    }
//
    fun getTransaksi(idUser:Int){
        viewModelScope.launch(Dispatchers.IO) {
            _transaksiData.postValue(repository.getTransaksi(idUser))
        }
    }
//
//    fun updateUser(userid:Int,nama:String,email:String,alamat:String,password: String){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.updateUser(userid,nama, email, alamat, password)
//        }
//    }
//
    fun addTransaksi(transaksi:TransaksiEntity):Int{
        var id=0
        viewModelScope.launch(Dispatchers.IO) {
            id = repository.addTransaksi(transaksi).toInt()
        }
        return id
    }
//
//    fun login(username:String,password:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            _loginData.postValue(repository.login(username, password))
//        }
//    }


}