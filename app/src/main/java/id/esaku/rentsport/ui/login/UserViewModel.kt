package id.esaku.rentsport.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.data.source.UserRepository
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.UserDatabase
import id.esaku.rentsport.domain.model.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val readAllData: LiveData<List<UserEntity>>
    private val _loginData = MutableLiveData<UserEntity?>()
    val loginData: LiveData<UserEntity?> get() = _loginData
    private val repository:UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user:UserEntity){
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