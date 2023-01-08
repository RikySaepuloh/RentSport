package id.esaku.rentsport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import id.esaku.rentsport.databinding.ActivityDetailRiwayatTransaksiBinding
import id.esaku.rentsport.databinding.ActivityLokasiBinding

class DetailRiwayatTransaksiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRiwayatTransaksiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailRiwayatTransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}