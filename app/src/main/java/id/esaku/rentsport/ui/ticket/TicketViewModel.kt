package id.esaku.rentsport.ui.ticket

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.data.source.UserRepository
import id.esaku.rentsport.data.source.local.entity.TicketEntity
import id.esaku.rentsport.data.source.local.room.TicketDatabase
import id.esaku.rentsport.data.source.local.room.UserDatabase
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class TicketViewModel(application: Application):AndroidViewModel(application) {
    private val readAllData: LiveData<List<TicketEntity>>
    private val _loginData = MutableLiveData<TicketEntity?>()
    val loginData: LiveData<TicketEntity?> get() = _loginData
    private val repository:UserRepository

    init{
        val ticketDao = TicketDatabase.getDatabase(application).ticketDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user:TicketEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun login(username:String,password:String){
        viewModelScope.launch(Dispatchers.IO) {
            _loginData.postValue(repository.login(username, password))
        }
    }

}