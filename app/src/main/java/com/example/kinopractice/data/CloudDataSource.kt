package com.example.kinopractice.data

import com.example.kinopractice.data.retrofit.ApiService
import com.example.kinopractice.domain.NetworkResult

interface CloudDataSource {
    suspend fun getFilms(filmsName: String): NetworkResult
    suspend fun addNewFilms(newFilms: String): NetworkResult
    suspend fun addNewTheaters(newTheaters: String): NetworkResult
    suspend fun getTheaters(theaterName: String): NetworkResult

    class Base(
        private val apiService: ApiService,
    ) : CloudDataSource {

        override suspend fun getFilms(filmsName: String): NetworkResult =
            try {
                val response = apiService.getFilms(filmsName)
                NetworkResult.Success(checkNotNull(response.body()))
            } catch (e: Exception) {
                NetworkResult.Failure(e.message ?: "exception")
            }

        override suspend fun addNewFilms(newFilms: String): NetworkResult {
            TODO("Not yet implemented")
        }

        override suspend fun addNewTheaters(newTheaters: String): NetworkResult {
            TODO("Not yet implemented")
        }

        override suspend fun getTheaters(theaterName: String): NetworkResult =
            try {
                val response = apiService.getTheaters(theaterName)
                NetworkResult.Success(checkNotNull(response.body()))
            } catch (e: Exception) {
                NetworkResult.Failure(e.message ?: "exception")
            }
    }
}