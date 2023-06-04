package com.akshayz.motobook.ui.vehicles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.akshayz.motobook.databinding.ItemVehicleBinding
import com.akshayz.motobook.models.Vehicles
import com.akshayz.motobook.utils.ActionPerformer
import com.bumptech.glide.Glide

class VehiclesAdapter(
    private val actionPerformer: ActionPerformer<VehiclesAction>,
    private val vehiclesList: List<Vehicles>
) :
    RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        val binding =
            ItemVehicleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return VehiclesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return vehiclesList.size
    }

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.binding.tvVehicleName.text = vehiclesList[position].vehicleName

        Glide
            .with(holder.binding.ivVehicleIcon.context)
            .load(vehiclesList[position])
            .placeholder(androidx.appcompat.R.drawable.abc_spinner_textfield_background_material)
            .into(holder.binding.ivVehicleIcon)

    }

    class VehiclesViewHolder(@NonNull val binding: ItemVehicleBinding) :
        RecyclerView.ViewHolder(binding.root)
}