package com.larkes.neurobuildermultiplatform.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.larkes.neurobuildermultiplatform.navigation.Navigation
import com.larkes.neurobuildermultiplatform.ui.theme.AppTheme

@Composable
fun App(){

    val navController = rememberNavController()

    AppTheme {
        Navigation(navController)
    }

}