package com.example.calculosfrankacosta.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.calculosfrankacosta.ViewModel.EmpleadoViewModel

@Composable
fun CalculoEmpleadoView(empleadoViewModel: EmpleadoViewModel) {
    var Salario by remember { mutableStateOf("") }
    val resultado by empleadoViewModel.resultado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = Salario,
            onValueChange = { Salario = it },
            label = { Text("Ingresa el salario base") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                empleadoViewModel.calcularSalarioNeto(Salario.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular salario neto")
        }
        Button(
            onClick = {
                empleadoViewModel.calcularHoraExtraDiurna(Salario.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Hora extra diurna")
        }
        Button(
            onClick = {
                empleadoViewModel.calcularHoraExtraNocturna(Salario.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Hora extra nocturna")
        }
        Button(
            onClick = {
                empleadoViewModel.calcularHoraDominical(Salario.toDouble())
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular hora dominical")
        }
        Text(text = "Resultado: ${resultado.toInt()}")
    }
}