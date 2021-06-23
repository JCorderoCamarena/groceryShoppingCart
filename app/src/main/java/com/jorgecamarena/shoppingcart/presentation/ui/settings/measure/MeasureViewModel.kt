package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.entity.Measure
import com.jorgecamarena.shoppingcart.data.repository.MeasureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasureViewModel @Inject constructor(
    private val measureRepository: MeasureRepository
): ViewModel() {

    var measureList: LiveData<List<Measure>> = MutableLiveData(listOf())

    var selectedMeasure: LiveData<Measure> = MutableLiveData()

    var isLoading by mutableStateOf(false)

    init {
        loadMeasures()
    }

    private fun loadMeasures() {
        isLoading = true
        viewModelScope.launch {
            measureRepository.getMeasures().let {
                measureList = it
            }
            isLoading = false
        }
    }

    fun getMeasureById(id: Long) {
        isLoading = true
        viewModelScope.launch {
            measureRepository.getMeasureById(id)?.let {
                selectedMeasure = it
                isLoading = false
            }
            isLoading = false
        }
    }

    fun insertMeasure(measure: Measure) {
        isLoading = true
        viewModelScope.launch {
            measureRepository.saveMeasure(measure)
            isLoading = false
        }
    }

    fun updateMeasure(measure: Measure) {
        isLoading = true
        viewModelScope.launch {
            measureRepository.updateMeasure(measure)
            isLoading = false
        }
    }

    fun deleteMeasure(measure: Measure) {
        isLoading = true
        viewModelScope.launch {
            measureRepository.deleteMeasure(measure)
            isLoading = false
        }
    }
}