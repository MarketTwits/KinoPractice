package com.example.kinopractice.presentation.add_theters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.kinopractice.KinoApp
import com.example.kinopractice.data.cloud_model.search_theathers.TheatersCloudItem
import com.example.kinopractice.databinding.ActivityFilmsBinding
import com.example.kinopractice.databinding.ActivityNewtheatreBinding
import com.example.kinopractice.presentation.search_theters.adapter.TheatersAdapter


class AddNewTheatersActivity : AppCompatActivity() {

    lateinit var binding : ActivityNewtheatreBinding
    private lateinit var viewModel : AddNewTheatersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewtheatreBinding.inflate(layoutInflater)
        viewModel = (application as KinoApp).addNewTheatersViewModel
        setContentView(binding.root)
        listener()
        observeViewModel()
    }
    private fun listener(){
        binding.button.setOnClickListener {
            val theatersName = binding.edTheatersName.text.toString()
            val theatersAddress = binding.edTheatersAddress.text.toString()
            viewModel.addTheater(theatersName, theatersAddress)
        }
    }
    private fun observeViewModel() {
       viewModel.message.observe(this){
           binding.tvInfo.text = it.toString()
       }
    }

}