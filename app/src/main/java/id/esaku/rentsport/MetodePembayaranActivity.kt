package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import id.esaku.rentsport.databinding.ActivityJadwalBinding
import id.esaku.rentsport.databinding.ActivityMetodePembayaranBinding
import id.esaku.rentsport.ui.TempatSewaViewModel

class MetodePembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMetodePembayaranBinding
    var id_lapang=0
    var id_ts=0
    var total=0
    private lateinit var mTempatSewaViewModel: TempatSewaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetodePembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        id_ts = intent.extras!!.getInt("id_ts",0)
        id_lapang = intent.extras!!.getInt("id_lapang",0)
        total = intent.extras!!.getInt("total",0)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnProses.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this,ProsesActivity::class.java))
        }

    }

    private fun createTransaction(){

    }
}