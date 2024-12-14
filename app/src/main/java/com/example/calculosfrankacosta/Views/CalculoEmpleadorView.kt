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
import com.example.calculosfrankacosta.ViewModel.EmpleadorViewModel
import com.example.calculosfrankacosta.ViewModel.HistorialViewModel

@Composable
fun CalculoEmpleadorView(empleadorViewModel: EmpleadorViewModel, Historial: HistorialViewModel) {
    var Salario by remember { mutableStateOf("") }

    val resultado by empleadorViewModel.resultado.collectAsState()
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
            value = Salario,
            onValueChange = { Salario = it },
            label = { Text("Ingresa el salario base") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                empleadorViewModel.calcularCostoTotalDeNomina(Salario.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular el total de nomina")
        }
        Button(
            onClick = {
                empleadorViewModel.calcularProvisionesSociales(Salario.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular provisiones sociales")
        }
        Button(
            onClick = {
                empleadorViewModel.calcularAportesParafiscales(Salario.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular aportes parafiscales")
        }
        Button(
            onClick = {
                empleadorViewModel.calcularPrestacionesSociales(Salario.toDouble())
                Historial.addCalculo(resultado.toString())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular prestaciones sociales")
        }
        Text(text = "Resultado: ${resultado}")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
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