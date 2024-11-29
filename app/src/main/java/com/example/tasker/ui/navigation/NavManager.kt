package com.example.tasker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasker.ui.home.HomeScreen
import com.example.tasker.ui.navigation.NavRoutes.*

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME.route
    ) {

        //region HomeScreen
        composable(
            route = HOME.route
        ){

            HomeScreen()

        }
        //endregion

    }

}