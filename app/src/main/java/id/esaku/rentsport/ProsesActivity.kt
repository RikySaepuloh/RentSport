package id.esaku.rentsport

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import id.esaku.rentsport.databinding.ActivityMetodePembayaranBinding
import id.esaku.rentsport.databinding.ActivityProsesBinding

class ProsesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProsesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProsesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this@ProsesActivity,MainActivity::class.java))
        }

        binding.btnSelesai.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this@ProsesActivity,MainActivity::class.java))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.timer.apply {
                isCountDown = true
                base = SystemClock.elapsedRealtime() + 60000*10
            }
            binding.timer.start()
            binding.timer.setOnChronometerTickListener {
                if (it.base == SystemClock.elapsedRealtime()){
                    binding.timer.stop()
                    binding.timer.text = "Waktu transaksi telah habis."
                }
            }
        }
    }
}