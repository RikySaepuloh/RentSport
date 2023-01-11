package id.esaku.rentsport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.esaku.rentsport.data.source.local.entity.DetailTransaksiEntity
import id.esaku.rentsport.data.source.local.entity.TransaksiEntity
import id.esaku.rentsport.databinding.ActivityMetodePembayaranBinding
import id.esaku.rentsport.ui.home.DetailTransaksiViewModel
import id.esaku.rentsport.ui.home.TempatSewaViewModel
import id.esaku.rentsport.ui.home.TransaksiViewModel
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MetodePembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMetodePembayaranBinding
    var id_lapang=0
    var id_ts=0
    var total=0
    private lateinit var mTransaksiViewModel: TransaksiViewModel
    private lateinit var mDetailTransaksiViewModel: DetailTransaksiViewModel
    val preferences = Preferences()
    private lateinit var mTempatSewaViewModel: TempatSewaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetodePembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mTransaksiViewModel = ViewModelProvider(this)[TransaksiViewModel::class.java]
        mDetailTransaksiViewModel = ViewModelProvider(this)[DetailTransaksiViewModel::class.java]
        mTempatSewaViewModel = ViewModelProvider(this)[TempatSewaViewModel::class.java]
        preferences.setPreferences(this)
        id_ts = intent.extras!!.getInt("id_ts",0)
        id_lapang = intent.extras!!.getInt("id_lapang",0)
        total = intent.extras!!.getInt("total",0)
        mTempatSewaViewModel.getTempatSewa(id_ts)
        mTempatSewaViewModel.tempatSewa.observe(this) {
            if (it != null) {
                binding.tvNamaTempatSewa.text = it.nama
            }
        }
        var totaljam = total/20000
        binding.tvTotal.text = "Rp"+intToCurr(total)
        binding.tvTotaljam.text = "$totaljam jam"

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnProses.setOnClickListener {
            createTransaction()
        }

    }

    private fun createTransaction(){
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())
        var id=mTransaksiViewModel.addTransaksi(TransaksiEntity(0,preferences.getIdDevice(),currentDate,false))
        mDetailTransaksiViewModel.addDetailTransaksi(DetailTransaksiEntity(id,id_lapang,"testing",total))
        finishAffinity()
        startActivity(Intent(this,ProsesActivity::class.java).putExtra("total",total).putExtra("id",id_ts))
    }


    fun intToCurr(value:Int): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        val formatted = formatter.format(value)
        return formatted.replace(",", ".")
    }
}