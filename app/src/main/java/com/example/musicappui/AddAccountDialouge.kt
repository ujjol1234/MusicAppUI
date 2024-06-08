package com.example.musicappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AccountDialog(dialogopen: MutableState<Boolean>){
    if(dialogopen.value){
        AlertDialog(onDismissRequest = { dialogopen.value=false },
            
            confirmButton = { TextButton(onClick = { dialogopen.value=false }) {
                Text(text = "Confirm")
            } },
            dismissButton = { TextButton(onClick = { dialogopen.value=false }) {
                Text(text = "Cancel")
            }}, text = {
                Column (modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center){
                    Text(text = "Create Account")
                    TextField(value = "", onValueChange = {
                    },
                        modifier = Modifier.padding(16.dp),
                        label = {Text(text = "Email")})
                    TextField(value = "", onValueChange = {},
                        Modifier.padding(16.dp),
                        label = { Text(text = "Password")})
                }
            }, shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .background(MaterialTheme.colors.primarySurface)
                .padding(8.dp),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
            
        }
    }