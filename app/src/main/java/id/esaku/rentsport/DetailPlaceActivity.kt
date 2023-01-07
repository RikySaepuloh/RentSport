package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import id.esaku.rentsport.databinding.ActivityDetailPlaceBinding
import id.esaku.rentsport.databinding.ActivityWelcomeBinding

class DetailPlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnPilihJadwal.setOnClickListener {
            if (binding.rgLapang.checkedRadioButtonId == -1){
                Snackbar.make(binding.root,"Ooops, kamu belum memilih lapangan",Snackbar.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(this,JadwalActivity::class.java))
            }
        }

    }
}