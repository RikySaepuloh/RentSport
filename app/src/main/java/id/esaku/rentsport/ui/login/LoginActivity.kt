package id.esaku.rentsport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import id.esaku.rentsport.MainActivity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.data.source.local.room.RentSportDatabase
import id.esaku.rentsport.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
//    val db = Room.databaseBuilder(
//        applicationContext,
//        RentSportDatabase::class.java, "rentsportdb"
//    ).build()
//    val userDao = db.userDao()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnLogin.setOnClickListener{
//            if (userDao.login(binding.etUsername.text.toString(),binding.etPassword.text.toString())){
            login()
//            }
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun login() {
//        val user= UserEntity("USR-001",binding.etNama.text.toString(),binding.etUsername.text.toString(),binding.etEmail.text.toString(),binding.etAlamat.text.toString(),binding.etPassword.text.toString())
        mUserViewModel.login(binding.etUsername.text.toString(),binding.etPassword.text.toString())
        mUserViewModel.loginData.observe(this) {
            if (it != null) {
                finishAffinity()
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Toast.makeText(this,"Username/Password salah",Toast.LENGTH_LONG).show()
            }
        }
//        binding.etNama.setText("")
//        binding.etUsername.setText("")
//        binding.etEmail.setText("")
//        binding.etPassword.setText("")
//        binding.etAlamat.setText("")
//        Toast.makeText(this,"Data berhasil dimasukkan", Toast.LENGTH_LONG).show()
    }
}