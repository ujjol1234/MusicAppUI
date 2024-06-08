package com.example.musicappui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val scaffoldstate:ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    val vm:MainViewModel= viewModel()
    //to find out our current path
    val controller:NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentPath = navBackStackEntry?.destination?.route

    val dialogOpen:MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val currentScreen = remember {
        vm.currentScreen.value
    }
    val title = remember{
        mutableStateOf( currentScreen.title)
    }

    //Import the right scaffold

    Scaffold (
        bottomBar = {
                    if(currentScreen is Screen.DrawerScreen || currentScreen is BottomScreen.Home){
                        BottomNavigation {
                            listofbottomitems.forEach{
                                val isSelected = currentPath == it.broute
                                BottomNavigationItem(       //this is a inbuilt function
                                    selected = currentScreen.route==it.broute,
                                    onClick = { controller.navigate(it.broute)
                                               vm.setCurrentScreen(it)
                                              title.value=it.btitle},
                                    icon = {
                                        val tint =if(isSelected)Color.White else Color.Black
                                        Icon(tint = tint,
                                            painter = painterResource(id =it.icon), contentDescription = it.btitle) })
                            }
                        }
                    }
        },
        topBar = {
            TopAppBar(title = {Text(text = title.value)},
                navigationIcon = { IconButton(onClick = {
                    scope.launch {
                        scaffoldstate.drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account Details")
                }}
            )
        },
        scaffoldState = scaffoldstate,
        drawerContent = {
            LazyColumn(Modifier.padding(16.dp)){
                items(listofitems){
                    DrawerItem(item = it, selected = currentPath==it.droute) {
                        scope.launch {
                            scaffoldstate.drawerState.close()
                        }
                       if(it.droute=="createaccount"){
                            dialogOpen.value=true
                       }
                        else{
                            controller.navigate(it.droute)
                            title.value=it.dtitle
                        }

                    }
                }
            }
        }
    ){
        Navigation(navController = controller, viewModel = vm,pd=it)
        AccountDialog(dialogopen = dialogOpen)
        }
    }


@Composable
fun DrawerItem(item:Screen.DrawerScreen,
    selected:Boolean,
               onItemSelected:()->Unit
               ){
    val background = if (selected) Color.DarkGray else Color.White
    Row (
        Modifier
            .background(background)
            .clickable { onItemSelected() }){
        Image(painter = painterResource(id = item.icon),
            contentDescription = item.dtitle,Modifier.padding(16.dp))
        Text(text = item.dtitle,Modifier.padding(16.dp))
    }
}