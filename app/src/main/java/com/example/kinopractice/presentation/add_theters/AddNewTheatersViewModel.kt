package com.example.kinopractice.presentation.add_theters

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

class AddNewTheatersViewModel(
    private val baseRepository: BaseRepository,
    private val dispatcher: DispatchersWrapper
) : ViewModel() {
    private val _message = MutableLiveData<String>()
     val message : LiveData<String> = _message


    fun addTheater(theatersName : String, theatersAddress : String){
        viewModelScope.launch(dispatcher.io()) {
            val data = baseRepository.addNewTheater(theatersName, theatersAddress)
            if(data.isSuccess()){
                withContext(dispatcher.ui()){
                    data as NetworkResult.Success<String>
                    _message.postValue(data.getData())
                }
            }else{
                withContext(dispatcher.ui()){
                    _message.postValue(data.errorMessage())
                }
            }
        }
    }
}