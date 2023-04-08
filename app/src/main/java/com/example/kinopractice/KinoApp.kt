package com.example.kinopractice

import android.app.Application
import com.example.kinopractice.data.CloudDataSource
import com.example.kinopractice.data.retrofit.RetrofitBuilder
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.BaseRepository
import com.example.kinopractice.presentation.ManageResources
import com.example.kinopractice.presentation.search_films.SearchFilmsViewModel
import com.example.kinopractice.presentation.add_theters.AddNewTheatersViewModel
import com.example.kinopractice.presentation.search_theters.SearchTheatersViewModel

class KinoApp : Application() {

     lateinit var searchFilmsViewModel: SearchFilmsViewModel
     lateinit var searchTheatersViewModel: SearchTheatersViewModel
     lateinit var addNewTheatersViewModel : AddNewTheatersViewModel
     private val apiService = RetrofitBuilder.getInstance

    override fun onCreate() {
        super.onCreate()
        searchFilmsViewModel = SearchFilmsViewModel(
            BaseRepository(cloudDataSource = CloudDataSource.Base(
                apiService,
            ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base()
        )
        searchTheatersViewModel = SearchTheatersViewModel(
            BaseRepository(cloudDataSource = CloudDataSource.Base(
                apiService,
                ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base()
        )
        addNewTheatersViewModel = AddNewTheatersViewModel(
            BaseRepository(cloudDataSource = CloudDataSource.Base(
                apiService,
                ManageResources.Base(this)
            )
            ),
            DispatchersWrapper.Base()
        )
    }
}