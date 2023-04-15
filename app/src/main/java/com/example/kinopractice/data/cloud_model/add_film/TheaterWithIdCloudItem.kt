package com.example.kinopractice.data.cloud_model.add_film

import com.example.kinopractice.presentation.model.TheaterWithIdForUI
import com.google.gson.annotations.SerializedName

data class TheaterWithIdCloudItem(
    @SerializedName("id")
    private val id: String,
    @SerializedName("name")
    private val name: String
){
    fun getUIItem() : TheaterWithIdForUI =
        TheaterWithIdForUI(id.toInt(), name)
}
