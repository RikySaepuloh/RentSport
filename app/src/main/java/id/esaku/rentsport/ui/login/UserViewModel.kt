package id.esaku.rentsport.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.esaku.rentsport.domain.repository.UserRepository
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val readAllData: LiveData<List<UserEntity>>
    private val _userData = MutableLiveData<UserEntity?>()
    val user: LiveData<UserEntity?> get() = _userData
    private val _loginData = MutableLiveData<UserEntity?>()
    val loginData: LiveData<UserEntity?> get() = _loginData
    private val repository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun getUser(userid:Int){
        viewModelScope.launch(Dispatchers.IO) {
            _userData.postValue(repository.getUser(userid))
        }
    }

    fun updateUser(userid:Int,nama:String,email:String,alamat:String,password: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(userid,nama, email, alamat, password)
        }
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