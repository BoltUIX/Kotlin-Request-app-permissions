package com.boltuix.materialuiux

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.boltuix.materialuiux.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    private var _binding: FragmentDemoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDemoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enableFineLocation.setOnClickListener {
            requestSinglePermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val requestSinglePermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Do something if permission granted
                binding.enableFineLocation.visibility=View.GONE
            }
            else {
                // Do something as the permission is not granted
                binding.enableFineLocation.visibility=View.VISIBLE
            }
        }
}