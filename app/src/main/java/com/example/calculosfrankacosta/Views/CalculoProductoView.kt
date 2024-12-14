package com.example.calculosfrankacosta.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.calculosfrankacosta.ViewModel.HistorialViewModel
import com.example.calculosfrankacosta.ViewModel.ProductoViewModel
import kotlin.math.absoluteValue

@Composable
fun CalculoProductoView(productoViewModel: ProductoViewModel, Historial: HistorialViewModel) {
    var precio by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var costoValorUnitario by remember { mutableStateOf("") }
    var PrecioVentaUnitario by remember { mutableStateOf("") }
    var CostoVariableUnitario by remember { mutableStateOf("") }
    var Ingresos by remember { mutableStateOf("") }
    var Inversion by remember { mutableStateOf("") }

    val resultado by productoViewModel.resultado.collectAsState()
    val lista by Historial.historial.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Ingresa el precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = costo,
            onValueChange = { costo = it },
            label = { Text("Ingresa el costo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = costoValorUnitario,
            onValueChange = { costoValorUnitario = it },
            label = { Text("Ingresa el costo valor unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = PrecioVentaUnitario,
            onValueChange = { PrecioVentaUnitario = it },
            label = { Text("Ingresa el precio venta unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = CostoVariableUnitario,
            onValueChange = { CostoVariableUnitario = it },
            label = { Text("Ingresa el cosoto variable unitario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = Ingresos,
            onValueChange = { Ingresos = it },
            label = { Text("Ingresa ingresos") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = Inversion,
            onValueChange = { Inversion = it },
            label = { Text("Ingresa inversio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                productoViewModel.calcularIva(precio.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular el iva")
        }
        Button(
            onClick = {
                productoViewModel.calcularMargenDeGanancias(precio.toDouble(), costo.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular margen de ganancia")
        }
        Button(
            onClick = {
                productoViewModel.calcularPuntoDeEquilibrio(PrecioVentaUnitario.toDouble(), CostoVariableUnitario.toDouble(), costo.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Punto de Equilibrio")
        }
        Button(
            onClick = {
                productoViewModel.calcularROI(Ingresos.toDouble(), Inversion.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular ROI")
        }
        Text(text = "Resultado: ${resultado.toInt()}")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espaciado entre elementos
        ) {
            items(lista) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Valor: $item",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF333333)
                            )
                        )
                    }
                }
            }
        }
    }
}