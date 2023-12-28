package com.example.datainternet.ui.theme.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datainternet.Model.Kontak
import com.example.datainternet.revository.KontakRepository
import kotlinx.coroutines.launch

sealed class KontakUIState{
    data class Success(val Kontak: List<Kontak>) : KontakUIState()

    object Error : KontakUIState()

    object Loading : KontakUIState()
}

class HomeViewModel(private val KontakRepository: KontakRepository) : ViewModel(){
    var KontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }

    fun getKontak(){
        viewModelScope.launch {
            KontakUIState = KontakUIState.Loading
            KontakUIState = try {
                KontakUIState.Success(KontakRepository.getKontak())
            } catch (e: IDException){
                KontakUIState.Error
            } catch (e: HttpException){
                KontakUIState.Loading
            }
        }
    }
}
