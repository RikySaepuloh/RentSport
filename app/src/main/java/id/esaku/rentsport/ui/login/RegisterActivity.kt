package id.esaku.rentsport.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnLogin.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            // TODO: ADD to table USER
            insertNewUserToDatabase()
        }
    }

    private fun insertNewUserToDatabase() {
         val user=UserEntity(0,binding.etNama.text.toString(),binding.etUsername.text.toString(),binding.etEmail.text.toString(),binding.etAlamat.text.toString(),binding.etPassword.text.toString())
        mUserViewModel.addUser(user)
        binding.etNama.setText("")
        binding.etUsername.setText("")
        binding.etEmail.setText("")
        binding.etPassword.setText("")
        binding.etAlamat.setText("")
        Toast.makeText(this,"Registrasi Berhasil",Toast.LENGTH_LONG).show()
        finish()
    }
}