package id.esaku.rentsport.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.domain.repository.TempatSewaRepository
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.data.source.local.room.TempatSewaDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TempatSewaViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<TempatSewaEntity>>
    private val _tempatSewaData = MutableLiveData<TempatSewaEntity?>()
    val tempatSewa: LiveData<TempatSewaEntity?> get() = _tempatSewaData
    private val repository: TempatSewaRepository

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

    fun addTempatSewa(tempatSewa:TempatSewaEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTempatSewa(tempatSewa)
        }
    }

}