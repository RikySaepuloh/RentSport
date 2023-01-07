package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import id.esaku.rentsport.databinding.ActivityJadwalBinding
import id.esaku.rentsport.databinding.ActivityMetodePembayaranBinding

class MetodePembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMetodePembayaranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetodePembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnProses.setOnClickListener {
            startActivity(Intent(this,ProsesActivity::class.java))
        }

    }
}