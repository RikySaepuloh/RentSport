package id.esaku.rentsport.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.esaku.rentsport.ui.login.EditProfileActivity
import id.esaku.rentsport.Preferences
import id.esaku.rentsport.ui.login.LoginActivity
import id.esaku.rentsport.TicketActivity
import id.esaku.rentsport.data.source.local.entity.UserEntity
import id.esaku.rentsport.databinding.FragmentNotificationsBinding
import id.esaku.rentsport.ui.login.UserViewModel

class NotificationsFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val preferences = Preferences()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences.setPreferences(requireContext())
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.getUser(preferences.getIdDevice())
        mUserViewModel.user.observe(this) {
            if (it != null) {
                setData(it)
            } else {
                Toast.makeText(requireContext(), "Terjadi kesalahan", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnKeluar.setOnClickListener{
            requireActivity().finishAffinity()
            preferences.preferencesLogout()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }

        binding.tvRaise.setOnClickListener {
            startActivity(Intent(requireActivity(),TicketActivity::class.java))
        }

        binding.civProfile.setOnClickListener {
            startActivity(Intent(requireActivity(), EditProfileActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(entity: UserEntity){
        binding.tvUsername.setText(entity.username)
        binding.tvNamaLengkap.setText(entity.nama)
        binding.tvEmail.setText(entity.email)
        binding.tvAlamat.setText(entity.alamat)
    }
}