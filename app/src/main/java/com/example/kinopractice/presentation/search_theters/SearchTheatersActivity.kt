package com.example.kinopractice.presentation.search_theters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.kinopractice.KinoApp
import com.example.kinopractice.data.cloud_model.search_theathers.TheatersCloudItem
import com.example.kinopractice.databinding.ActivityFilmsBinding
import com.example.kinopractice.presentation.add_theters.AddNewTheatersViewModel
import com.example.kinopractice.presentation.search_theters.adapter.TheatersAdapter


class SearchTheatersActivity : AppCompatActivity() {

    lateinit var binding : ActivityFilmsBinding
    private lateinit var viewModel : SearchTheatersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmsBinding.inflate(layoutInflater)
        viewModel = (application as KinoApp).searchTheatersViewModel
        setContentView(binding.root)
        listener()
        observeViewModel()
    }
    private fun listener(){
        binding.button.setOnClickListener {
            val theaters = binding.editTextTextPersonName.text.toString()
            viewModel.getTheaters(theaters = theaters)
        }
    }
    private fun observeViewModel() {
        viewModel.searchTheaters.observe(this) {
            binding.tvInfo.isVisible = false
            binding.rvMain.isVisible = true
            setUpList(it)
        }
        viewModel.errorMessage.observe(this){
            if (it.isNotEmpty()){
                binding.rvMain.isVisible = false
                binding.tvInfo.isVisible = true
                binding.tvInfo.text = it
            }
        }
    }
    private fun setUpList(data : List<TheatersCloudItem>){
        val adapter = TheatersAdapter(data)
        binding.rvMain.adapter = adapter
    }
}