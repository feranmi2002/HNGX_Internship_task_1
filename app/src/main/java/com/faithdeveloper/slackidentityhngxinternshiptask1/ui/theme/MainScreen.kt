package com.faithdeveloper.slackidentityhngxinternshiptask1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.faithdeveloper.slackidentityhngxinternshiptask1.R

@Composable
fun MainScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "My name")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "My profile picture")
        Button(onClick = {
//            open github web page
        }) {
            Text(modifier = Modifier.wrapContentSize(align = Alignment.Center), text = "OPEN GITHUB")
        }

    }
}