package id.esaku.rentsport.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.checkbox.MaterialCheckBox
import id.esaku.rentsport.MetodePembayaranActivity
import id.esaku.rentsport.databinding.ActivityJadwalBinding
import java.text.DecimalFormat
import java.text.NumberFormat

class JadwalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadwalBinding
    var total=0
    var id_ts=0
    var id_lapang=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.extras!=null){
            id_ts = intent.extras!!.getInt("id_ts",0)
            id_lapang = intent.extras!!.getInt("id_lapang",0)
        }
        initJadwal(
            arrayListOf(
                binding.cb08,
                binding.cb09,
                binding.cb10,
                binding.cb11,
                binding.cb12,
                binding.cb13,
                binding.cb14,
                binding.cb15,
                binding.cb16,
                binding.cb17,
                binding.cb18,
                binding.cb19,
                binding.cb20,
                binding.cb21)
        )

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnPilihMetode.setOnClickListener {
            if (total==0 || total < 0){
                Toast.makeText(this,"Anda belum memilih jadwal",Toast.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(this, MetodePembayaranActivity::class.java).putExtra("id_ts",id_ts).putExtra("id_lapang",id_lapang).putExtra("total",total))
            }
        }

    }

    private fun initJadwal(jadwal: ArrayList<MaterialCheckBox>) {
        for (i in 0 until jadwal.size){
            jadwal[i].setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    total+=20000
                }else{
                    total-=20000
                }
                binding.tvTotal.text = "Rp"+intToCurr(total)
            }
        }
    }

    fun intToCurr(value:Int): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        val formatted = formatter.format(value)
        return formatted.replace(",", ".")
    }
}