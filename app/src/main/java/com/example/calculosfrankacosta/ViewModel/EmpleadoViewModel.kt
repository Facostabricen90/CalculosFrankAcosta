package com.example.calculosfrankacosta.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EmpleadoViewModel: ViewModel() {
    private val _resultado = MutableStateFlow(0.0)
    val resultado = _resultado.asStateFlow()

    fun calcularSalarioNeto(salario: Double){
        _resultado.value = salario - (salario * 0.08)
    }

    fun calcularHoraExtraDiurna(salario: Double){
        _resultado.value = ( salario / 240 ) * 1.25
    }

    fun calcularHoraExtraNocturna(salario: Double){
        _resultado.value = ( salario / 240 ) * 1.75
    }

    fun calcularHoraDominical(salario: Double){
        _resultado.value = ( salario / 240 ) * 2
    }
}