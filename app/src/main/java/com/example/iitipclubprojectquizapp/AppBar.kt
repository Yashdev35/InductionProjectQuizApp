package com.example.iitipclubprojectquizapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon : (@Composable () -> Unit)? =
        if(!title.contains("Lets get ready to Rumble")) {
            {
                IconButton(onClick = {
                    onBackNavClicked()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back button on top bar",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }else{
            null
        }
    TopAppBar(
        title = {
        Text(title , color = colorResource(id = R.color.white),
            modifier = Modifier.padding(start = 4.dp).heightIn(max = 24.dp))
    },
        elevation = 3.dp,
        backgroundColor = Color(0xFF1A1A1A),
        navigationIcon = navigationIcon
        )
}

@Preview
@Composable
fun AppBarPreview(){
    AppBar(title = "Wish Lis"){}
}