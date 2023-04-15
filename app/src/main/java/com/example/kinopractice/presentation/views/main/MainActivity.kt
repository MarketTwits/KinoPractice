package com.example.kinopractice.presentation.views.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.kinopractice.R
import com.example.kinopractice.databinding.ActivityMainBinding
import com.example.kinopractice.presentation.views.add_film.AddFilmActivity
import com.example.kinopractice.presentation.views.add_theters.AddNewTheatersActivity
import com.example.kinopractice.presentation.views.search_films.SearchFilmsActivity
import com.example.kinopractice.presentation.views.search_theters.SearchTheatersActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent: Intent? = null
        intent = when (item.itemId) {
            R.id.m1 -> Intent(this, SearchTheatersActivity::class.java)
            R.id.m2 -> Intent(this, SearchFilmsActivity::class.java)
            R.id.m3 -> Intent(this, AddNewTheatersActivity::class.java)
            R.id.m4 -> Intent(this, AddFilmActivity::class.java)
            else -> return super.onOptionsItemSelected(item)
        }
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
    private fun setupListener(){
        binding.imSearchFilm.setOnClickListener {
            startSelectedActivity(SearchFilmsActivity::class.java)
        }
        binding.imAddTheater.setOnClickListener {
            startSelectedActivity(AddNewTheatersActivity::class.java)
        }
        binding.imAddFilm.setOnClickListener{
            startSelectedActivity(AddFilmActivity::class.java)
        }
        binding.imGetTheater.setOnClickListener {
           startSelectedActivity(SearchFilmsActivity::class.java)
        }
    }
    private fun startSelectedActivity(clazz: Class<*>){
        startActivity(Intent(this, clazz))
    }
}