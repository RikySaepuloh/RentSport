package id.esaku.rentsport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.esaku.rentsport.MainActivity
import id.esaku.rentsport.Preferences
import id.esaku.rentsport.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mUserViewModel: UserViewModel
    val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences.setPreferences(this)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnLogin.setOnClickListener{
            login()
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
                preferences.saveIdDevice(it.idUser)
                finishAffinity()
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Toast.makeText(this,"Username/Password salah",Toast.LENGTH_LONG).show()
            }
        }
    }
}