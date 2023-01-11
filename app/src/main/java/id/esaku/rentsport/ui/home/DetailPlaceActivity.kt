package id.esaku.rentsport.ui.home

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import id.esaku.rentsport.databinding.ActivityDetailPlaceBinding

class DetailPlaceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPlaceBinding
    private lateinit var mTempatSewaViewModel: TempatSewaViewModel
    var id:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mTempatSewaViewModel = ViewModelProvider(this)[TempatSewaViewModel::class.java]
        try {
            id = intent.extras?.getInt("id",0)!!
        } catch (e: Exception) {
            Log.e(TAG,e.message.toString())
        }

        mTempatSewaViewModel.getTempatSewa(id)
        mTempatSewaViewModel.tempatSewa.observe(this) {
            if (it != null) {
                binding.tvNamaRekomendasi.text = it.nama
                binding.tvAlamat.text = it.alamat
                binding.tvDeskripsi.text = it.deskripsi
                Glide.with(this).load(it.foto).into(binding.ivImage)
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnPilihJadwal.setOnClickListener {
            if (binding.rgLapang.checkedRadioButtonId == -1){
                Snackbar.make(binding.root,"Ooops, kamu belum memilih lapangan",Snackbar.LENGTH_SHORT).show()
            }else{
                var id_lapang = 0
                when (binding.rgLapang.checkedRadioButtonId) {
                    binding.rbFutsal.id -> {
                        id_lapang = 1
                    }
                    binding.rbVoli.id -> {
                        id_lapang = 2
                    }
                    binding.rbBasket.id -> {
                        id_lapang = 3
                    }
                }
                startActivity(Intent(this, JadwalActivity::class.java).putExtra("id_lapang",id_lapang).putExtra("id_ts",id))
            }
        }

    }
}