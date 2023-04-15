package com.example.kinopractice.data.retrofit

import com.example.kinopractice.data.cloud_model.add_film.TheaterWithIDCloud
import com.example.kinopractice.data.cloud_model.search_film.FilmCloud
import com.example.kinopractice.data.cloud_model.search_theathers.TheatersCloud
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("kino/?id=2")
    suspend fun getFilms(@Query(QUERY_PARAM_NAME) name: String
    ): Response<FilmCloud>

    @GET("kino/?id=1")
    suspend fun getTheaters(@Query(QUERY_PARAM_NAME) name: String
    ): Response<TheatersCloud>

    @GET("kino/?id=3")
    suspend fun getTheatersWithId(): Response<TheaterWithIDCloud>

    @FormUrlEncoded
    @POST("kino")
    suspend fun addNewTheater(
        @Field("id") id: Int = 1,
        @Field("name") name: String,
        @Field("address") address: String
    ) : String

    @FormUrlEncoded
    @POST("kino")
    suspend fun addNewFilm(
        @Field("id") id: Int = 2,
        @Field("name") name: String,
    ) : String


    @FormUrlEncoded
    @POST("kino")
    suspend fun addTheaterIdFilmId(
        @Field("id") id: Int = 3,
        @Field("theatreID") theaterId: String,
        @Field("filmID") filmId: String,
    ) : String

    companion object{
        private const val QUERY_PARAM_NAME = "name"
    }
}
