package com.example.musicappui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavController,viewModel: MainViewModel,pd:PaddingValues){
    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.droute ){
        composable(Screen.DrawerScreen.Account.droute){
            Account()
        }
        composable(Screen.DrawerScreen.Subscription.droute){
            Subscription()
        }
        composable(BottomScreen.Home.route){
            Home()
        }
        composable(BottomScreen.Library.route){
            Library()
        }
        composable(BottomScreen.Browse.route){
            Browse()
        }

    }
}