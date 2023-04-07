package com.example.kinopractice.presentation.search_theters.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopractice.data.cloud_model.search_film.FilmCloudItem
import com.example.kinopractice.data.cloud_model.search_theathers.TheatersCloudItem
import com.example.kinopractice.databinding.ItemTheatersBinding

class TheatersAdapter(var lines: List<TheatersCloudItem>) :
    RecyclerView.Adapter<TheatersAdapter.TheatersViewHolder>() {
    override fun getItemCount(): Int {
        return lines.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheatersViewHolder {
        val binding =
            ItemTheatersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TheatersViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TheatersViewHolder, position: Int) {
        val p = lines[position]
        val binding = holder.binding
        binding.tvTheaterAddress.text = p.address
        binding.tvTheaterName.text = p.name
    }
    class TheatersViewHolder(val binding : ItemTheatersBinding) : RecyclerView.ViewHolder(binding.root)
}