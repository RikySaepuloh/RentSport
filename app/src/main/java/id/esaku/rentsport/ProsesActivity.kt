package id.esaku.rentsport

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import id.esaku.rentsport.databinding.ActivityProsesBinding
import id.esaku.rentsport.ui.home.TempatSewaViewModel
import java.text.DecimalFormat
import java.text.NumberFormat


class ProsesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProsesBinding
    var total=0
    var id_ts=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProsesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        total = intent.extras!!.getInt("total",0)
        id_ts = intent.extras!!.getInt("id",0)

        binding.tvTotal.text = "Rp"+intToCurr(total)

        binding.btnBack.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this@ProsesActivity,MainActivity::class.java))
        }

        binding.btnSelesai.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this@ProsesActivity,MainActivity::class.java))
        }
        
        binding.btnCopyNorek.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("norek", binding.tvNorek.text)
            clipboard.setPrimaryClip(clip)
            Snackbar.make(binding.root,"Berhasil disalin",Snackbar.LENGTH_SHORT).show()
        }

        binding.btnCopyTotal.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("total", binding.tvTotal.text.substring(2).replace(".",""))
            clipboard.setPrimaryClip(clip)
            Snackbar.make(binding.root,"Berhasil disalin",Snackbar.LENGTH_SHORT).show()
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

    fun intToCurr(value:Int): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        val formatted = formatter.format(value)
        return formatted.replace(",", ".")
    }
}