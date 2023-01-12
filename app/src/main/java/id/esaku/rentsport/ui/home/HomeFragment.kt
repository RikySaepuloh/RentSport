package id.esaku.rentsport.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.esaku.rentsport.LokasiActivity
import id.esaku.rentsport.R
import id.esaku.rentsport.data.source.local.entity.TempatSewaEntity
import id.esaku.rentsport.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mTempatSewaViewModel: TempatSewaViewModel
    val myadapter = TempatSewaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTempatSewaViewModel = ViewModelProvider(this)[TempatSewaViewModel::class.java]
        binding.rvDidekatmu.apply {
            adapter = myadapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        initTempatSewa()
        binding.btnRekomendasi.setOnClickListener {
            requireContext().startActivity(Intent(this.activity, DetailPlaceActivity::class.java))
        }

        binding.tvLokasi.setOnClickListener {
            startActivity(Intent(requireActivity(), LokasiActivity::class.java))
        }
    }


    private fun initTempatSewa(){
        mTempatSewaViewModel.addTempatSewa(
            TempatSewaEntity(1,"Moriz Futsal", "Jl. Encep Kartawiria No.121, Citeureup, Kec. Cimahi Utara, Kota Cimahi, Jawa Barat 40512", "Moriz Futsal adalah tempat penyewaan lapangan olahraga. Kami selalu mengutamakan kenyamanan dan kelengkapan dari lapangan kami. Salah satu dari 5 tempat penyewaan lapangan olahraga terbesar di Kota Cimahi.",
                R.drawable.img_dummy,3)
        )
        mTempatSewaViewModel.addTempatSewa(TempatSewaEntity(2,"IFI Futsal", "Jl. H. Umar No.7 Sukabirus", "Deskripsi Tempat Sewa untuk lapangan futsal",R.drawable.img_ifi_futsal,4))
        mTempatSewaViewModel.addTempatSewa(
            TempatSewaEntity(3,"Batununggal Sport Center", "Mengger, Kec. Bandung kidul", "Tempat sewa untuk lapangan Basket, Gym, Renang",
                R.drawable.img_btngl,5)
        )
        mTempatSewaViewModel.readAllData.observe(viewLifecycleOwner) {
            myadapter.initData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}