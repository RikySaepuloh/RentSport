package id.esaku.rentsport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import id.esaku.rentsport.R
import id.esaku.rentsport.databinding.ActivityLokasiBinding

class LokasiActivity : AppCompatActivity(), OnMapReadyCallback{
    private lateinit var binding: ActivityLokasiBinding
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLokasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-6.972368030791445, 107.631556653961)
        mMap.addMarker(
            MarkerOptions()
            .position(sydney)
            .title("Telkom University"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
    }
}