package com.example.kinopractice.presentation.views.add_theters

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kinopractice.KinoApp
import com.example.kinopractice.data.cloud_model.add_film.TheaterWithIdCloudItem
import com.example.kinopractice.databinding.ActivityNewtheatreBinding
import com.example.kinopractice.presentation.views.add_film.adapter.AddNewFilmAdapter


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
        viewModel.event.observe(this){
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}