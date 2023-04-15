package com.example.kinopractice.domain

interface Repository {
    suspend fun getFilms(filmsName: String) : NetworkResult
    suspend  fun getTheaters(theatersName : String) : NetworkResult
    suspend fun addNewTheater(theatersName: String,
                              theatersAddress : String
    ) : NetworkResult
    suspend fun addTheaterIDFilmId(theaterId : String, filmId : String
    ) : NetworkResult
    suspend fun addNewFilm(filmsName: String) : NetworkResult
    suspend fun getTheatersWithId() : NetworkResult
}