package com.example.calculosfrankacosta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculosfrankacosta.Navigation.NavManager
import com.example.calculosfrankacosta.ViewModel.ProductoViewModel
import com.example.calculosfrankacosta.ui.theme.CalculosFrankAcostaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productoViewModel : ProductoViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            CalculosFrankAcostaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(productoViewModel)
                }
            }
        }
    }
}
