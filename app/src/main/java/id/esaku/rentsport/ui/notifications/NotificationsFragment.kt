package id.esaku.rentsport.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.esaku.rentsport.EditProfileActivity
import id.esaku.rentsport.ui.login.LoginActivity
import id.esaku.rentsport.TicketActivity
import id.esaku.rentsport.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
        binding.btnKeluar.setOnClickListener{
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }

        binding.tvRaise.setOnClickListener {
            startActivity(Intent(requireActivity(),TicketActivity::class.java))
        }

        binding.civProfile.setOnClickListener {
            startActivity(Intent(requireActivity(),EditProfileActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}