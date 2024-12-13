package com.example.calculosfrankacosta.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculosfrankacosta.ViewModel.EmpleadoViewModel
import com.example.calculosfrankacosta.ViewModel.EmpleadorViewModel
import com.example.calculosfrankacosta.ViewModel.ProductoViewModel
import com.example.calculosfrankacosta.Views.CalculoEmpleadorView
import com.example.calculosfrankacosta.Views.CalculoEmpleadoView
import com.example.calculosfrankacosta.Views.CalculoProductoView
import com.example.calculosfrankacosta.Views.Home

@Composable
fun NavManager (productoViewModel: ProductoViewModel, empleadoViewModel: EmpleadoViewModel, empleadorViewModel: EmpleadorViewModel){
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = "home"
    ){
        composable("home"){
            Home(navController)
        }
        composable("CalculoEmpleadorView"){
            CalculoEmpleadorView(empleadorViewModel)
        }
        composable("CalculoEmpleadoView"){
            CalculoEmpleadoView(empleadoViewModel)
        }
        composable("CalculoProductoView"){
            CalculoProductoView(productoViewModel)
        }
    }
}