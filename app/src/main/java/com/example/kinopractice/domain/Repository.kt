package com.example.kinopractice.domain

import com.example.kinopractice.data.CloudDataSource

class Repository(
    private val cloudDataSource: CloudDataSource,
) {
    suspend fun getFilms(filmsName: String) : NetworkResult{
        return cloudDataSource.getFilms(filmsName)
    }
    suspend  fun getTheaters(theatersName : String) : NetworkResult{
     return cloudDataSource.getTheaters(theatersName)
    }

}