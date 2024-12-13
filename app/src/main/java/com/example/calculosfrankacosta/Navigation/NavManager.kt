package com.example.calculosfrankacosta.Navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculosfrankacosta.ViewModel.ProductoViewModel
import com.example.calculosfrankacosta.Views.CalculoEmpleadoView
import com.example.calculosfrankacosta.Views.CalculoEmpleadorView
import com.example.calculosfrankacosta.Views.CalculoProductoView
import com.example.calculosfrankacosta.Views.Home

@Composable
fun NavManager (productoViewModel: ProductoViewModel){
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = "home"
    ){
        composable("home"){
            Home(navController)
        }
        composable("CalculoEmpleadoView"){
            CalculoEmpleadoView()
        }
        composable("CalculoEmpleadorView"){
            CalculoEmpleadorView()
        }
        composable("CalculoProductoView"){
            CalculoProductoView(productoViewModel)
        }
    }
}