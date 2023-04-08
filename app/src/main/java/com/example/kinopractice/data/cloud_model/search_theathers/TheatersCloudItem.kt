package com.example.kinopractice.data.cloud_model.search_theathers

import com.google.gson.annotations.SerializedName

data class TheatersCloudItem(
    @SerializedName("address")
    val theatersAddress: String,
    @SerializedName("name")
    val theatersName: String
)