package com.example.kinopractice.presentation.views.search_films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopractice.data.cloud_model.search_film.FilmCloudItem
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.NetworkResult
import com.example.kinopractice.domain.BaseRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFilmsViewModel(
    private val baseRepository: BaseRepository,
    private val dispatcher: DispatchersWrapper
) : ViewModel() {
    private val _searchFilms = MutableLiveData<List<FilmCloudItem>>()
     val searchFilms : LiveData<List<FilmCloudItem>> = _searchFilms

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage

    fun getFilms(film : String){
        viewModelScope.launch(dispatcher.io()) {
            val data = baseRepository.getFilms(film)
            if(data.isSuccess()){
                withContext(dispatcher.ui()){
                    data as NetworkResult.Success<List<FilmCloudItem>>
                    _searchFilms.postValue(data.getData())
                    _errorMessage.postValue("")
                }
            }else{
                withContext(dispatcher.ui()){
                    _errorMessage.postValue(data.errorMessage())
                }
            }
        }
    }
}