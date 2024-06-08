package com.example.musicappui

import androidx.annotation.DrawableRes

sealed class Screen (val title:String,val route:String){
    sealed class DrawerScreen(val dtitle:String,val droute:String,@DrawableRes val icon:Int):Screen(dtitle,droute){
        object Account:DrawerScreen("Account",
            "account",
            R.drawable.account)
        object Subscription:DrawerScreen("Subscription",
            "subscription",
            R.drawable.baseline_subscription)
        object CreateAccount:DrawerScreen("Create Account",
            "createaccount",
            R.drawable.baseline_add_account)
    }
}

sealed class BottomScreen(val btitle:String,val broute:String,@DrawableRes val icon:Int):Screen(btitle,broute){
    object Home:BottomScreen("Home","home",R.drawable.baseline_home_24)
    object Library:BottomScreen("Library","library",R.drawable.baseline_library_music_24)
    object Browse:BottomScreen("Browse","browse",R.drawable.baseline_search_24)
}

val listofitems= listOf(Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.CreateAccount)

val listofbottomitems = listOf(BottomScreen.Home,
    BottomScreen.Browse,
    BottomScreen.Library)

sealed class LibraryObj(val title:String,@DrawableRes val icon: Int){
    object Playlist:LibraryObj("Playlist",R.drawable.baseline_playlist_play_24)
    object Artists:LibraryObj("Artists",R.drawable.baseline_record_voice_over_24)
    object Albums:LibraryObj("Albums",R.drawable.baseline_album_24)
    object Songs:LibraryObj("Songs",R.drawable.baseline_queue_music_24)
    object Genre:LibraryObj("Genre",R.drawable.baseline_library_music_24)
}

val listoflibraryitems = listOf(LibraryObj.Playlist,
    LibraryObj.Albums,
    LibraryObj.Artists,
    LibraryObj.Genre,
    LibraryObj.Songs)


