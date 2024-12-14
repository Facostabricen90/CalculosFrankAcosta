package com.example.calculosfrankacosta.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EmpleadorViewModel: ViewModel() {
    private val _resultado = MutableStateFlow(0.0)
    val resultado = _resultado.asStateFlow()

    fun calcularCostoTotalDeNomina(salario: Double){
        _resultado.value = (salario * (20.5 / 100)) +
                (salario * ( 9 / 100 )) +
                (salario * ( 21.83 / 100 ))
    }

    fun calcularProvisionesSociales(salario: Double){
        _resultado.value = salario * (20.5 / 100)
    }

    fun calcularAportesParafiscales(salario: Double){
        _resultado.value = salario * ( 9 / 100 )
    }

    fun calcularPrestacionesSociales(salario: Double){
        _resultado.value = salario * ( 21.83 / 100 )
    }
}