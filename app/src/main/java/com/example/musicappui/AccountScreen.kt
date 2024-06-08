package com.example.musicappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Account(){
   Column (){
       Row (modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween){//for space between the objects
           Row (Modifier.padding(8.dp)){
               Image(
                   painter = painterResource(id = R.drawable.baseline_account_circle_24),
                   contentDescription = "Account",
                   Modifier.padding(8.dp)
               )
               Column {
                   Text(text = "Ujjol")
                   Text(text = "Ujjol@gmail.com")
               }
           }
           IconButton(onClick = { /*TODO*/ }) {

               Icon(
                   imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                   contentDescription = "Right Arrow"
               )
           }
       }
   }
}