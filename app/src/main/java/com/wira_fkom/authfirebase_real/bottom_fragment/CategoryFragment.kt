package com.wira_fkom.authfirebase_real.bottom_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wira_fkom.authfirebase_real.LoginActivity
import com.wira_fkom.authfirebase_real.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set onClickListener to navigate to LoginActivity using NavController
//        binding.btnLogout.setOnClickListener {
//            startActivity(Intent(requireContext(), LoginActivity::class.java))
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
