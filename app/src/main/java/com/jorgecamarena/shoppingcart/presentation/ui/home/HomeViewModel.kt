package com.jorgecamarena.shoppingcart.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    init {
        Log.d("DEBUG", "$cartRepository")
        viewModelScope.launch {  }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getData() {
        viewModelScope.launch {
            // wait
            text
        }
    }
}