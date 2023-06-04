package com.akshayz.motobook.ui.vehicles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akshayz.motobook.R
import com.akshayz.motobook.utils.ActionPerformer


class VehiclesFragment : Fragment(), ActionPerformer<VehiclesAction> {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicles, container, false)
    }

    override fun performAction(action: VehiclesAction) {

        when(action) {
            is VehicleSelected -> showVehiclesDialog()
        }

    }

    private fun showVehiclesDialog() {




    }

}