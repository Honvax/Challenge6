package com.alfrsms.challenge6.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfrsms.challenge6.wrapper.Resource
import com.alfrsms.challenge6.data.network.model.detail.DetailMovie
import com.alfrsms.challenge6.data.repository.MovieRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    private val _detailResult = MutableLiveData<Resource<DetailMovie>>()
    val detailResult: LiveData<Resource<DetailMovie>> get() = _detailResult

    fun getDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getDetail(id)
            viewModelScope.launch(Dispatchers.Main) {
                _detailResult.postValue(data)
            }
        }
    }
}