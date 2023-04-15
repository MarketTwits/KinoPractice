package com.example.kinopractice.presentation.views.add_film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopractice.R
import com.example.kinopractice.data.cloud_model.add_film.TheaterWithIdCloudItem
import com.example.kinopractice.domain.BaseRepository
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.NetworkResult
import com.example.kinopractice.presentation.utils.InputStringValidation
import com.example.kinopractice.presentation.utils.ManageResources
import com.example.kinopractice.presentation.model.TheaterWithIdForUI
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddFilmViewModel(
    private val baseRepository: BaseRepository,
    private val dispatcher: DispatchersWrapper,
    private val inputStringValidation: InputStringValidation,
    private val manageResources: ManageResources,
) : ViewModel() {

    private val _event = MutableLiveData<String>()
    val event: LiveData<String> = _event

    private val _theaters = MutableLiveData<List<TheaterWithIdForUI>>()
    val theaters: LiveData<List<TheaterWithIdForUI>> = _theaters

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _filmId = MutableLiveData<String>()
    val filmId : LiveData<String> = _filmId


    fun getTheaters() {
        viewModelScope.launch(dispatcher.io()) {
            val data = baseRepository.getTheatersWithId()
            if (data.isSuccess()) {
                withContext(dispatcher.ui()) {
                    data as NetworkResult.Success<List<TheaterWithIdCloudItem>>
                    _theaters.postValue(map(data.getData()))
                }
            } else {
                withContext(dispatcher.ui()) {
                    _message.postValue(data.errorMessage())
                }
            }
        }
    }
     fun addNewFilm(filmsName : String){
         if (!inputStringValidation.validate(filmsName)) {
             viewModelScope.launch(dispatcher.io()) {
                 val result = baseRepository.addNewFilm(filmsName)
                 if (result.isSuccess()) {
                     withContext(dispatcher.ui()) {
                         result as NetworkResult.Success<String>
                         _message.postValue(result.getData())
                         _filmId.postValue(result.getResponse())
                     }
                 } else {
                     withContext(dispatcher.ui()) {
                         _message.postValue(result.errorMessage())
                     }
                 }
             }
         }else{
             _event.value = manageResources.string(R.string.fill_all_fields)
         }
    }
     fun addTheatersFilm(theaterId: String, filmsId: String) {
         viewModelScope.launch(dispatcher.io()) {
             val result = baseRepository.addTheaterIDFilmId(theaterId, filmsId)
             if (result.isSuccess()){
                 withContext(dispatcher.ui()) {
                     result as NetworkResult.Success<String>
                     _message.postValue(result.getData())
                 }
             }
             else {
                 withContext(dispatcher.ui()) {
                     _message.postValue(result.errorMessage())
                 }
             }
         }
    }

    private fun map(list : List<TheaterWithIdCloudItem>
    ) : List<TheaterWithIdForUI> {
        val newList = mutableListOf<TheaterWithIdForUI>()
        list.forEach { newList.add(it.getUIItem()) }
        return newList
    }

    override fun onCleared() {
        super.onCleared()
        _message.value = null
        _theaters.value = null
    }
}
