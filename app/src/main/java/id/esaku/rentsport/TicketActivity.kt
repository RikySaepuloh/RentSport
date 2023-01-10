package id.esaku.rentsport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner
import id.esaku.rentsport.databinding.ActivityTicketBinding


class TicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.spJenis.setItems("Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow")
        binding.spJenis.setOnItemSelectedListener(MaterialSpinner.OnItemSelectedListener<String> { view, position, id, item ->
            Snackbar.make(
                view,
                "Clicked $item",
                Snackbar.LENGTH_LONG
            ).show()
        })
    }
}