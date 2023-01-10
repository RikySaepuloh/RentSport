package id.esaku.rentsport.ui.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.github.dhaval2404.imagepicker.ImagePicker
import id.esaku.rentsport.MainActivity
import id.esaku.rentsport.Preferences
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.databinding.ActivityEditProfileBinding
import id.esaku.rentsport.databinding.ActivityJadwalBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var mUserViewModel: UserViewModel
    val preferences = Preferences()

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                Toast.makeText(this, "Berhasil diubah", Toast.LENGTH_SHORT).show()
//                mProfileUri = fileUri
//                imgProfile.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
//                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences.setPreferences(this)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.getUser(preferences.getIdDevice())
        mUserViewModel.user.observe(this) {
            if (it != null) {
                setData(it)
            } else {
                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.civProfile.setOnClickListener {
            ImagePicker.with(this)
                .compress(1024)         //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)  //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }
        }

        binding.btnUbah.setOnClickListener {
            updateProfile(preferences.getIdDevice(),binding.etNama.text.toString(),binding.etEmail.text.toString(),binding.etAlamat.text.toString(),binding.etPassword.text.toString())
        }
    }

    private fun updateProfile(userid: Int,nama:String,email:String,alamat:String,password: String){
        mUserViewModel.updateUser(userid,nama,email, alamat, password)
        Toast.makeText(this,"Data Berhasil Diubah",Toast.LENGTH_LONG).show()
        finish()
    }

    private fun setData(entity:UserEntity){
        binding.etUserid.setText(entity.idUser.toString())
        binding.etUsername.setText(entity.username)
        binding.etNama.setText(entity.nama)
        binding.etEmail.setText(entity.email)
        binding.etAlamat.setText(entity.alamat)
        binding.etPassword.setText(entity.password)
    }
}