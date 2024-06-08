package com.example.musicappui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.Account)

        val currentScreen:MutableState<Screen>
        get() = _currentScreen  //this makes currentscreen = _currentscreen

    fun setCurrentScreen(screen:Screen){
        _currentScreen.value=screen
    }
}