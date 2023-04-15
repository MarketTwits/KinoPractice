package com.example.kinopractice.presentation.views.search_films

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.kinopractice.KinoApp
import com.example.kinopractice.data.cloud_model.search_film.FilmCloudItem
import com.example.kinopractice.databinding.ActivityFilmsBinding
import com.example.kinopractice.presentation.views.search_films.adapter.FilmsAdapter


class SearchFilmsActivity : AppCompatActivity() {

    lateinit var binding : ActivityFilmsBinding
    private lateinit var viewModel : SearchFilmsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmsBinding.inflate(layoutInflater)
        viewModel = (application as KinoApp).searchFilmsViewModel
        setContentView(binding.root)
        listener()
        observeViewModel()
    }
    private fun listener(){
        binding.button.setOnClickListener {
            val film = binding.editTextTextPersonName.text.toString()
            viewModel.getFilms(film = film)
        }
    }
    private fun observeViewModel() {
        viewModel.searchFilms.observe(this) {
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
    private fun setUpList(data : List<FilmCloudItem>){
        val adapter = FilmsAdapter(data)
        binding.rvMain.adapter = adapter
    }
}