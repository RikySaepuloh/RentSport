package id.esaku.rentsport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.esaku.rentsport.databinding.ActivityEditProfileBinding
import id.esaku.rentsport.databinding.ActivityJadwalBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}