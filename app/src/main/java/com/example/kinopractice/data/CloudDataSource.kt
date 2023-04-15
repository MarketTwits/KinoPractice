package com.example.kinopractice.data

import com.example.kinopractice.R
import com.example.kinopractice.data.retrofit.ApiService
import com.example.kinopractice.domain.NetworkResult
import com.example.kinopractice.presentation.utils.ManageResources

interface CloudDataSource {
    suspend fun getFilms(filmsName: String): NetworkResult
    suspend fun addNewFilms(newFilms: String): NetworkResult
    suspend fun addNewTheaters(newTheatersName: String, newTheatersAddress: String): NetworkResult
    suspend fun addTheaterIDFilmId(theaterId : String, filmId : String) : NetworkResult
    suspend fun getTheaters(theaterName: String): NetworkResult
    suspend fun getTheatersWithId() : NetworkResult
    class Base(
        private val apiService: ApiService,
        private val manageResources: ManageResources,
    ) : CloudDataSource {
        override suspend fun getFilms(filmsName: String): NetworkResult {
            return try {
                val response = apiService.getFilms(filmsName)
                if (checkNotNull(response.body()).isNotEmpty()) {
                    NetworkResult.Success(checkNotNull(response.body()), response.toString())
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.film_not_found))
                }
            } catch (e: Exception) {
                NetworkResult.Failure(e.message ?: manageResources.string(R.string.exception))
            }
        }
        override suspend fun addNewFilms(newFilms: String): NetworkResult {
            return try {
                val response =
                    apiService.addNewFilm(name = newFilms)
                if (response.isNotEmpty() || response == "10") {
                    NetworkResult.Success(manageResources.string(R.string.film_added), response)
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.exception))
                }
            } catch (e: Exception) {
                NetworkResult.Failure(e.message.toString())
            }
        }

        override suspend fun addNewTheaters(
            newTheatersName: String,
            newTheatersAddress: String,
        ): NetworkResult {
            return try {
                val response =
                    apiService.addNewTheater(name = newTheatersName, address = newTheatersAddress)
                if (response.isNotEmpty() || response == "1") {
                    NetworkResult.Success(manageResources.string(R.string.theater_added))
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.film_not_found))
                }
            } catch (e: Exception) {
                NetworkResult.Failure(e.message.toString())
            }
        }

        override suspend fun addTheaterIDFilmId(theaterId: String, filmId: String) : NetworkResult {
            return try {
                val response =
                    apiService.addTheaterIdFilmId(theaterId = theaterId, filmId = filmId)
                if (response.isNotEmpty() || response == "1") {
                    NetworkResult.Success(manageResources.string(R.string.theater_added))
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.exception))
                }
            } catch (e: Exception) {
                NetworkResult.Failure(e.message.toString())
            }
        }

        override suspend fun getTheaters(theaterName: String): NetworkResult {
            return try {
                val response = apiService.getTheaters(theaterName)
                if (checkNotNull(response.body()).isNotEmpty()) {
                    NetworkResult.Success(checkNotNull(response.body()))
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.theaters_not_found))
                }
                NetworkResult.Success(checkNotNull(response.body()))
            } catch (e: Exception) {
                NetworkResult.Failure(e.message ?: manageResources.string(R.string.exception))
            }
        }

        override suspend fun getTheatersWithId(): NetworkResult {
            return try {
                val response = apiService.getTheatersWithId()
                if (checkNotNull(response.body()).isNotEmpty()) {
                    NetworkResult.Success(checkNotNull(response.body()))
                } else {
                    NetworkResult.Failure(manageResources.string(R.string.theaters_not_found))
                }
                NetworkResult.Success(checkNotNull(response.body()))
            } catch (e: Exception) {
                NetworkResult.Failure(e.message ?: manageResources.string(R.string.exception))
            }
        }
    }
}