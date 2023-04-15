package com.example.kinopractice.domain

import com.example.kinopractice.data.CloudDataSource

class BaseRepository(
    private val cloudDataSource: CloudDataSource,
) : Repository {

    override suspend fun getFilms(filmsName: String): NetworkResult {
        return cloudDataSource.getFilms(filmsName)
    }

    override suspend fun getTheaters(theatersName: String): NetworkResult {
        return cloudDataSource.getTheaters(theatersName)
    }

    override suspend fun getTheatersWithId(): NetworkResult {
        return cloudDataSource.getTheatersWithId()
    }

    override suspend fun addNewTheater(
        theatersName: String,
        theatersAddress: String,
    ): NetworkResult {
        return cloudDataSource.addNewTheaters(theatersName, theatersAddress)
    }

    override suspend fun addTheaterIDFilmId(theaterId: String, filmId: String): NetworkResult {
        return cloudDataSource.addTheaterIDFilmId(theaterId, filmId)
    }

    override suspend fun addNewFilm(filmsName: String): NetworkResult {
        return cloudDataSource.addNewFilms(filmsName)
    }

}