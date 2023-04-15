package com.example.kinopractice.presentation.views.add_film

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kinopractice.KinoApp
import com.example.kinopractice.data.cloud_model.add_film.TheaterWithIdCloudItem
import com.example.kinopractice.databinding.ActivityFilmsBinding
import com.example.kinopractice.databinding.ActivityNewfilmBinding
import com.example.kinopractice.presentation.views.add_film.adapter.AddNewFilmAdapter
import com.example.kinopractice.presentation.model.TheaterWithIdForUI

class AddFilmActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewfilmBinding
    lateinit var viewModel: AddFilmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (application as KinoApp).addNewFilmsViewModel
        binding = ActivityNewfilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observeViewModel()
    }

    private fun init() {
        viewModel.getTheaters()
    }

    private fun observeViewModel() {
        viewModel.theaters.observe(this) {
            setupLister(it)
        }
        viewModel.message.observe(this) {
            binding.tvInfo.text = it.toString()
        }
        viewModel.event.observe(this){
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupLister(list: List<TheaterWithIdForUI>) {
        val adapter = AddNewFilmAdapter(list)
        binding.lvMain.adapter = adapter
        binding.button.setOnClickListener {
            val filmsName = binding.edFilmName.text.toString()
            viewModel.addNewFilm(filmsName)

            val selected = adapter.getSelectedItem()
            if (selected != null) {
                viewModel.filmId.observe(this) {
                    viewModel.addTheatersFilm(selected.id.toString(), it)
                }
            } else {
                Toast.makeText(this, "Chose one theater", Toast.LENGTH_SHORT).show()
            }
        }
    }
}