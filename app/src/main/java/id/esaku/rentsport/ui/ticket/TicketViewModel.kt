package id.esaku.rentsport.ui.ticket

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.esaku.rentsport.data.source.local.entity.TicketEntity
import id.esaku.rentsport.data.source.local.room.TicketDatabase

class TicketViewModel(application: Application):AndroidViewModel(application) {
//    private val readAllData: LiveData<List<TicketEntity>>
    private val _loginData = MutableLiveData<TicketEntity?>()
    val loginData: LiveData<TicketEntity?> get() = _loginData
//    private val repository:UserRepository

    init{
        val ticketDao = TicketDatabase.getDatabase(application).ticketDao()
//        repository = TicketRepository(ticketDao)
//        readAllData = repository.readAllData
    }
//
//    fun addUser(user:TicketEntity){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addUser(user)
//        }
//    }
//
//    fun login(username:String,password:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            _loginData.postValue(repository.login(username, password))
//        }
//    }

}