package com.example.kinopractice.presentation.views.add_theters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopractice.R
import com.example.kinopractice.domain.DispatchersWrapper
import com.example.kinopractice.domain.NetworkResult
import com.example.kinopractice.domain.BaseRepository
import com.example.kinopractice.presentation.utils.InputStringValidation
import com.example.kinopractice.presentation.utils.ManageResources
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewTheatersViewModel(
    private val baseRepository: BaseRepository,
    private val dispatcher: DispatchersWrapper,
    private val inputStringValidation: InputStringValidation,
    private val manageResources: ManageResources,
) : ViewModel() {
    private val _event = MutableLiveData<String>()
    val event: LiveData<String> = _event
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message


    fun addTheater(theatersName: String, theatersAddress: String) {
        if (!inputStringValidation.validate(theatersName) && !inputStringValidation.validate(theatersAddress)
        ) {
            viewModelScope.launch(dispatcher.io()) {
                val data = baseRepository.addNewTheater(theatersName, theatersAddress)
                if (data.isSuccess()) {
                    withContext(dispatcher.ui()) {
                        data as NetworkResult.Success<String>
                        _message.postValue(data.getData())
                    }
                } else {
                    withContext(dispatcher.ui()) {
                        _message.postValue(data.errorMessage())
                    }
                }
            }
        } else {
            _event.value = manageResources.string(R.string.fill_all_fields)
        }
    }
}
