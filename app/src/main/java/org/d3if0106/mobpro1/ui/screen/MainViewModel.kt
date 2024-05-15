package org.d3if0106.mobpro1.ui.screen


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0106.mobpro1.network.HewanApi

class MainViewModel : ViewModel() {
    init {
        retriveData()
    }

    private fun retriveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = HewanApi.service.getHewan()
                Log.d("MainViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}