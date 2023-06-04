package com.akshayz.motobook.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.akshayz.motobook.R
import com.akshayz.motobook.databinding.FragmentHomeBinding
import com.akshayz.motobook.utils.navigateSafe


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController(view)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
        }

        setOnClickListeners()


        return root
    }

    private fun setOnClickListeners() {
        binding.btnVehicles.setOnClickListener {
            openVehiclesFragment()
        }

        binding.btnDocuments.setOnClickListener {
            openDocumentFragment()
        }
    }

    private fun openVehiclesFragment() {
        findNavController(binding.root).navigateSafe(R.id.action_homeFragment_to_vehiclesFragment)
    }

    private fun openDocumentFragment() {
        findNavController(binding.root).navigateSafe(R.id.action_homeFragment_to_documentsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}