package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.esaku.rentsport.databinding.ActivityDetailPlaceBinding
import id.esaku.rentsport.databinding.ActivityJadwalBinding

class JadwalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadwalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnPilihMetode.setOnClickListener {
            startActivity(Intent(this,MetodePembayaranActivity::class.java))
        }
    }
}