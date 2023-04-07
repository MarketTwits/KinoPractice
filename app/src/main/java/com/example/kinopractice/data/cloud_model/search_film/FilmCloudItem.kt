package com.example.kinopractice.data.cloud_model.search_film

import com.google.gson.annotations.SerializedName

data class FilmCloudItem(
    @SerializedName("name")
    val theaters_name: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("fname")
    val films_name: String,
)