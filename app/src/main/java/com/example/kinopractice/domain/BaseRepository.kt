package com.example.kinopractice.domain

import com.example.kinopractice.data.CloudDataSource

class BaseRepository(
    private val cloudDataSource: CloudDataSource,
) : Repository {

    override suspend fun getFilms(filmsName: String) : NetworkResult{
        return cloudDataSource.getFilms(filmsName)
    }
    override suspend  fun getTheaters(theatersName : String) : NetworkResult{
     return cloudDataSource.getTheaters(theatersName)

    }
    override suspend fun addNewTheater(
        theatersName: String,
        theatersAddress: String,
    ): NetworkResult {
        return cloudDataSource.addNewTheaters(theatersName, theatersAddress)
    }

    override suspend fun addNewFilm() {
        TODO("Not yet implemented")
    }

}