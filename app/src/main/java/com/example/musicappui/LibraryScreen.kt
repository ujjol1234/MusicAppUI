package com.example.musicappui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Library(){
    LazyColumn(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
            .fillMaxWidth()){
        items(listoflibraryitems){
            Libraryobject(title = it.title, icon = it.icon)
        }
    }
}

@Composable
fun Libraryobject(title:String,@DrawableRes icon:Int){
    Row (
        Modifier
            .clickable { }
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Row (modifier = Modifier.padding(2.dp)){
            Image(painter = painterResource(id = icon), contentDescription = "title", modifier = Modifier.padding(horizontal =  8.dp))
            Text(text = title)
        }
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = title)
    }
    Divider()
}