package com.jorgecamarena.shoppingcart.presentation.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.entity.Measure
import com.jorgecamarena.shoppingcart.data.entity.Status
import com.jorgecamarena.shoppingcart.data.repository.MeasureRepository
import com.jorgecamarena.shoppingcart.data.repository.StatusRepository
import com.jorgecamarena.shoppingcart.utils.MeasuresUtil
import com.jorgecamarena.shoppingcart.utils.StatusUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val statusRepository: StatusRepository,
    private val measureRepository: MeasureRepository
): ViewModel() {

    var isAppReady by mutableStateOf(false)

    init {
        viewModelScope.launch {
            saveMeasures(MeasuresUtil.buildListOfMeasures())
            saveStatus(StatusUtil.buildListOfStatus())
            delay(5000)
            isAppReady = true
        }
    }

    private fun saveMeasures(measureList: List<Measure>) {
        viewModelScope.launch {
            measureList.forEach {
                measureRepository.saveMeasure(measure = it)
            }
        }
    }

    private fun saveStatus(statusList: List<Status>) {
        viewModelScope.launch {
            statusList.forEach {
                statusRepository.insertStatus(it)
            }
        }
    }

}