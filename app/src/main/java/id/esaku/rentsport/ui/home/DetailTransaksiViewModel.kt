package id.esaku.rentsport.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.data.source.local.entity.DetailTransaksiEntity
import id.esaku.rentsport.domain.repository.TransaksiRepository
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.data.source.local.room.DetailTransaksiDatabase
import id.esaku.rentsport.data.source.local.room.TransaksiDatabase
import id.esaku.rentsport.domain.repository.DetailTransaksiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailTransaksiViewModel(application: Application):AndroidViewModel(application) {
//    val readAllData: LiveData<List<TransaksiEntity>>
    private val _transaksiData = MutableLiveData<List<DetailTransaksiEntity?>>()
    val transaksiData: LiveData<List<DetailTransaksiEntity?>> get() = _transaksiData
//    private val _loginData = MutableLiveData<UserEntity?>()
//    val loginData: LiveData<UserEntity?> get() = _loginData
    private val repository: DetailTransaksiRepository

    init{
        val detailtransaksiDao = DetailTransaksiDatabase.getDatabase(application).detailTransaksiDao()
        repository = DetailTransaksiRepository(detailtransaksiDao)
    }
//
    fun getDetailTransaksi(idTransaksi: Int)= repository.getDetailTransaksi(idTransaksi)

    fun addDetailTransaksi(transaksi:DetailTransaksiEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDetailTransaksi(transaksi)
        }
    }

}