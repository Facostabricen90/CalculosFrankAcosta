package com.example.calculosfrankacosta.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculosfrankacosta.ViewModel.ProductoViewModel

@Composable
fun CalculoProductoView(productoViewModel: ProductoViewModel) {
    var precio by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var costoValorUnitario by remember { mutableStateOf("") }
    var PrecioVentaUnitario by remember { mutableStateOf("") }
    var CostoVariableUnitario by remember { mutableStateOf("") }
    var Ingresos by remember { mutableStateOf("") }
    var Inversion by remember { mutableStateOf("") }

    val resultado by productoViewModel.resultado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Ingresa el precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = costo,
            onValueChange = { costo = it },
            label = { Text("Ingresa el costo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = costoValorUnitario,
            onValueChange = { costoValorUnitario = it },
            label = { Text("Ingresa el costo valor unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = PrecioVentaUnitario,
            onValueChange = { PrecioVentaUnitario = it },
            label = { Text("Ingresa el precio venta unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = CostoVariableUnitario,
            onValueChange = { CostoVariableUnitario = it },
            label = { Text("Ingresa el cosoto variable unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = Ingresos,
            onValueChange = { Ingresos = it },
            label = { Text("Ingresa ingresos") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = Inversion,
            onValueChange = { Inversion = it },
            label = { Text("Ingresa inversio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                productoViewModel.calcularIva(precio.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular el iva")
        }
        Button(
            onClick = {
                productoViewModel.calcularMargenDeGanancias(precio.toDouble(), costo.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular margen de ganancia")
        }
        Button(
            onClick = {
                productoViewModel.calcularPuntoDeEquilibrio(PrecioVentaUnitario.toDouble(), CostoVariableUnitario.toDouble(), costo.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Punto de Equilibrio")
        }
        Button(
            onClick = {
                productoViewModel.calcularROI(Ingresos.toDouble(), Inversion.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular ROI")
        }
    }
    Text(text = "Resultado: ${resultado.toInt()}")
}