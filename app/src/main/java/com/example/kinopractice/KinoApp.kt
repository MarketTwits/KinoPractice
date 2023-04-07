package com.example.kinopractice

import android.app.Application
import com.example.kinopractice.data.CloudDataSource
import com.example.kinopractice.data.retrofit.RetrofitBuilder
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.Repository
import com.example.kinopractice.presentation.search_films.SearchFilmsViewModel
import com.example.kinopractice.presentation.search_theters.SearchTheatersViewModel

class KinoApp : Application() {

     lateinit var searchFilmsViewModel: SearchFilmsViewModel
     lateinit var searchTheatersViewModel: SearchTheatersViewModel
    private val apiService = RetrofitBuilder.getInstance

    override fun onCreate() {
        super.onCreate()
        searchFilmsViewModel = SearchFilmsViewModel(
            Repository(cloudDataSource = CloudDataSource.Base(apiService)),
            DispatchersWrapper.Base()
        )
        searchTheatersViewModel = SearchTheatersViewModel(
            Repository(cloudDataSource = CloudDataSource.Base(apiService)),
            DispatchersWrapper.Base()
        )
    }
}