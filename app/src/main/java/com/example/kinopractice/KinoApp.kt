package com.example.kinopractice

import android.app.Application
import com.example.kinopractice.data.CloudDataSource
import com.example.kinopractice.data.retrofit.RetrofitBuilder
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.BaseRepository
import com.example.kinopractice.presentation.utils.InputStringValidation
import com.example.kinopractice.presentation.utils.ManageResources
import com.example.kinopractice.presentation.views.add_film.AddFilmViewModel
import com.example.kinopractice.presentation.views.search_films.SearchFilmsViewModel
import com.example.kinopractice.presentation.views.add_theters.AddNewTheatersViewModel
import com.example.kinopractice.presentation.views.search_theters.SearchTheatersViewModel

class KinoApp : Application() {

    lateinit var searchFilmsViewModel: SearchFilmsViewModel
    lateinit var searchTheatersViewModel: SearchTheatersViewModel
    lateinit var addNewTheatersViewModel: AddNewTheatersViewModel
    lateinit var addNewFilmsViewModel: AddFilmViewModel
    private val apiService = RetrofitBuilder.getInstance

    override fun onCreate() {
        super.onCreate()


        searchFilmsViewModel = SearchFilmsViewModel(
            BaseRepository(
                cloudDataSource = CloudDataSource.Base(
                    apiService,
                    ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base()
        )
        searchTheatersViewModel = SearchTheatersViewModel(
            BaseRepository(
                cloudDataSource = CloudDataSource.Base(
                    apiService,
                    ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base()
        )
        addNewTheatersViewModel = AddNewTheatersViewModel(
            BaseRepository(
                cloudDataSource = CloudDataSource.Base(
                    apiService,
                    ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base(),
            InputStringValidation.Base(),
            ManageResources.Base(this)
        )
        addNewFilmsViewModel = AddFilmViewModel(
            BaseRepository(
                cloudDataSource = CloudDataSource.Base(
                    apiService,
                    ManageResources.Base(this)
                )
            ),
            DispatchersWrapper.Base(),
            InputStringValidation.Base(),
            ManageResources.Base(this)
        )
    }
}