package com.example.musicappui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

@Composable
fun Browse(){
    val categories= listOf("Hits","Happy","Workout","Running","Yoga")
    val grouped = listOf("New Releases","Favourites","Top Rated").groupBy { it[0] }
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(categories){
            BroseerItem(grp = it, drawable = R.drawable.baseline_new_releases_24)
        }
    }
}