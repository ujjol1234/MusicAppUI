package com.example.musicappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Subscription(){
    Column (modifier = Modifier.fillMaxSize()){
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Manage Subscription")
        }
        Card(onClick = { /*TODO*/ }, elevation = (2.dp)) {
        Column {
            Text(text = "Musical")
            Text(text = "Free Tier")
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "See All Plans")
                }
            }
            Divider(Modifier.padding(horizontal = 8.dp),thickness =(1.dp))
            Row (modifier = Modifier.padding(8.dp)){
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Account",Modifier.padding(4.dp))
                Text(text = "Get a plan", modifier = Modifier.padding(4.dp))
            }
        }
        }
    }
}