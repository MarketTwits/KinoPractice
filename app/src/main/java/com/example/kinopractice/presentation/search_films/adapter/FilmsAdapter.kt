package com.example.kinopractice.presentation.search_films.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopractice.data.cloud_model.search_film.FilmCloudItem
import com.example.kinopractice.databinding.ItemFilmBinding
import com.example.kinopractice.presentation.search_theters.adapter.TheatersAdapter

class FilmsAdapter(var lines: List<FilmCloudItem>) :
    RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {
    override fun getItemCount(): Int {
        return lines.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val binding =
            ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val p = lines[position]
        val binding = holder.binding
        binding.tvFilmName.text = p.films_name
        binding.tvTheaterAddress.text = p.address
        binding.tvTheaterName.text = p.theaters_name
    }
    class FilmsViewHolder(val binding : ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)
}