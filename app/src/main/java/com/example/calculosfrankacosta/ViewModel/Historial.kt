package com.example.calculosfrankacosta.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HistorialViewModel : ViewModel() {

    private val _historial = MutableStateFlow<List<String>>(emptyList())
    val historial: StateFlow<List<String>> = _historial

    fun addCalculo(valor: String){
        val nuevaLista = _historial.value.toMutableList().apply {
            add(valor)
        }
        _historial.value = nuevaLista
    }
}