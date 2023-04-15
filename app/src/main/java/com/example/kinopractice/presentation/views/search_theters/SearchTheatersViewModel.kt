package com.example.kinopractice.presentation.views.search_theters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopractice.data.cloud_model.search_theathers.TheatersCloudItem
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.NetworkResult
import com.example.kinopractice.domain.BaseRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchTheatersViewModel(
    private val baseRepository: BaseRepository,
    private val dispatcher: DispatchersWrapper
) : ViewModel() {
    private val _searchTheaters = MutableLiveData<List<TheatersCloudItem>>()
     val searchTheaters : LiveData<List<TheatersCloudItem>> = _searchTheaters

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage

    fun getTheaters(theaters : String){
        viewModelScope.launch(dispatcher.io()) {
            val data = baseRepository.getTheaters(theaters)
            if(data.isSuccess()){
                withContext(dispatcher.ui()){
                    data as NetworkResult.Success<List<TheatersCloudItem>>
                    _searchTheaters.postValue(data.getData())
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