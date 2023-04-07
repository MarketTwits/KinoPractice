package com.example.kinopractice.data.retrofit

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

    @FormUrlEncoded
    @POST("kino")
    suspend fun addNewTheater(
        @Field("id") id: Int = 1,
        @Field("name") name: String,
        @Field("address") address: String
    ) : ResponseBody

    @POST("")
    suspend fun addNewFilm(

    )

    companion object{
        private const val QUERY_PARAM_NAME = "name"
    }
}
