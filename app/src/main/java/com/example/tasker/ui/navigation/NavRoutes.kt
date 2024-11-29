package com.example.tasker.ui.navigation

sealed class NavRoutes(val route : String){

    object HOME : NavRoutes(route = "HOME")

}
