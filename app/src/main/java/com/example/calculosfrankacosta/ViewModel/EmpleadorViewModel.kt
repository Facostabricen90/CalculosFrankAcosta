package com.example.calculosfrankacosta.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class EmpleadorViewModel: ViewModel() {
    private val _resultado = MutableStateFlow(0.0)
    val resultado = _resultado.asStateFlow()

    fun calcularCostoTotalDeNomina(salario: Double){
        var total = 0.0
        total.plus(calcularProvisionesSociales(salario))
        total.plus(calcularAportesParafiscales(salario))
        total.plus(calcularPrestacionesSociales(salario))
        _resultado.value = total
    }

    fun calcularProvisionesSociales(salario: Double): Double{
        _resultado.value = salario * (20.5 / 100)
        return _resultado.value
    }

    fun calcularAportesParafiscales(salario: Double): Double{
        _resultado.value = salario * ( 9 / 100 )
        return _resultado.value
    }

    fun calcularPrestacionesSociales(salario: Double): Double{
        _resultado.value = salario * ( 21.83 / 100 )
        return _resultado.value
    }
}