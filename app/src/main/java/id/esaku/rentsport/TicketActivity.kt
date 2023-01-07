package id.esaku.rentsport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.esaku.rentsport.databinding.ActivityProsesBinding
import id.esaku.rentsport.databinding.ActivityTicketBinding

class TicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}