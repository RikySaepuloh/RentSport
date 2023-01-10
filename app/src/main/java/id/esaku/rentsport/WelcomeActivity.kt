package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.esaku.rentsport.databinding.ActivityWelcomeBinding
import id.esaku.rentsport.ui.login.LoginActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    val preferences = Preferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences.setPreferences(this)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (preferences.getIdDevice()!=0){
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding.btnExplore.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}