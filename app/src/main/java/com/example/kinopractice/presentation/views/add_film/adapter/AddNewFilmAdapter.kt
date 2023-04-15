package com.example.kinopractice.presentation.views.add_film.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopractice.data.cloud_model.add_film.TheaterWithIdCloudItem
import com.example.kinopractice.databinding.ItemAddNewFilmBinding
import com.example.kinopractice.presentation.model.TheaterWithIdForUI

class AddNewFilmAdapter(private var lines: List<TheaterWithIdForUI>) :
    RecyclerView.Adapter<AddNewFilmAdapter.AddNewFilmAdapterViewHolder>() {
    private var selectedItem = -1

    override fun getItemCount(): Int {
        return lines.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddNewFilmAdapterViewHolder {
        val binding =
            ItemAddNewFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddNewFilmAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AddNewFilmAdapterViewHolder,
        @SuppressLint("RecyclerView") position: Int,
    ) {
        val item = lines[position]

        val binding = holder.binding
        binding.checkBox.isChecked = position == selectedItem
        binding.tvText.text = item.name

        binding.checkBox.setOnClickListener {
            if (selectedItem != position) {
                selectedItem = position
                notifyDataSetChanged()
            }
        }
    }
    fun getSelectedItem(): TheaterWithIdForUI? {
        return if (selectedItem != -1) {
            lines[selectedItem]
        } else {
            null
        }
    }

    class AddNewFilmAdapterViewHolder(val binding: ItemAddNewFilmBinding) :
        RecyclerView.ViewHolder(binding.root)
}




