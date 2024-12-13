package com.example.calculosfrankacosta.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductoViewModel : ViewModel(){

    private val _resultado = MutableStateFlow(0.0)
    val resultado = _resultado.asStateFlow()

    fun calcularIva(precio: Double){
        _resultado.value = precio * 1.19
    }

    fun calcularMargenDeGanancias(PrecioVenta: Double, Costo: Double){
        _resultado.value = ((PrecioVenta - Costo) / PrecioVenta) * 100
    }

    fun calcularPuntoDeEquilibrio(PrecioVentaUnitario: Double, CostoVariableUnitario: Double, Costos: Double){
        _resultado.value = Costos / (PrecioVentaUnitario - CostoVariableUnitario)
    }

    fun calcularROI(Ingresos: Double, Inversion: Double){
        _resultado.value = ( ( Ingresos - Inversion ) / Inversion) * 100
    }
}