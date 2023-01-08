package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import id.esaku.rentsport.data.source.local.room.RentSportDatabase
import id.esaku.rentsport.databinding.ActivityLoginBinding
import id.esaku.rentsport.databinding.ActivityProsesBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val db = Room.databaseBuilder(
        applicationContext,
        RentSportDatabase::class.java, "rentsportdb"
    ).build()
    val userDao = db.userDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            if (userDao.login(binding.etUsername.text.toString(),binding.etPassword.text.toString())){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}