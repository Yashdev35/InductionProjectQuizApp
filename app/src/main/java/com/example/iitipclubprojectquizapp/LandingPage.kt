package com.example.iitipclubprojectquizapp

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//this is the landing page of the app, it contains the start button which will navigate to the quiz screen
@Composable
fun LandingPage(
    navigateToQuizScreen:()->Unit
){
    Scaffold(
        topBar = {
            AppBar(title = "Lets get ready to Rumble!")
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it).background(color = colorResource(id = R.color.black)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text ="Welcome to Quiz App",fontSize = 20.sp,fontWeight = FontWeight.Bold,color = Color.White)
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {
                   navigateToQuizScreen()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp),
                colors = buttonColors(
                    backgroundColor = colorResource(id = R.color.white),
                    contentColor = Color.White
                ),
                shape = CircleShape,
                border = BorderStroke(1.dp, color = Color.White)
            ) {
                Text(text = "Start the Rumble",color = Color.Black,fontSize = 15.sp,fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview
@Composable
fun LandingPagePreview() {
    LandingPage(navigateToQuizScreen = {})
}