package com.example.iitipclubprojectquizapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.iitipclubprojectquizapp.data.QuestionObj
import com.example.iitipclubprojectquizapp.data.Result

@Composable
fun HomeScreen(
    viewState : MainViewModel.QuestionsState
){
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        /*in this when block either we are processing the data or we are displaying the data or we are displaying the error
         and each case will have a different ui*/
        when{
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "ERROR")
            }
            else -> {
                var question by remember { mutableStateOf(listOf<Result>()) }
                val dummyQuestion = Result(
                    category = "General Knowledge",
                    type = "boolean",
                    difficulty = "medium",
                    question = "The Great Wall of China is visible from the moon.",
                    correct_answer = "False",
                    incorrect_answers = listOf("True")
                )
                question = viewState.questiondata?.results?.plus(dummyQuestion) ?:listOf(dummyQuestion)
                QuizScreen(questions = question)
            }
        }
    }
}

@Composable
fun QuizScreen(
questions : List<Result>
){
    val userAns = remember { mutableStateOf(true) }


Scaffold(
topBar = {
AppBar(title = "Quiz App",{

})
}
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(it),
    ){
      Box(
          modifier = Modifier
              .fillMaxWidth()
              .wrapContentHeight()
              .padding(10.dp),
          contentAlignment = Alignment.Center
      ){
           Column (
               modifier = Modifier
                   .fillMaxWidth()
                   .wrapContentHeight()
                   .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
           ){
               Text(
                   text = "Quiz App",
                   style = TextStyle(
                       color = colorResource(id = R.color.black),
                       fontWeight = FontWeight.Bold,
                       fontSize = 20.sp
                   )
               )
               Text(
                   text = "your current score is 0",
                   style = TextStyle(
                       color = colorResource(id = R.color.black),
                       fontWeight = FontWeight.Bold,
                       fontSize = 20.sp
                   )
               )
           }
      }
QuestionCard(question =questions[0].question)
Row (
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp),
    horizontalArrangement = Arrangement.Center,
){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp),
        shape = CircleShape,
        colors = buttonColors(
            backgroundColor = Color.Green,
            contentColor = Color.Black
        )
    ) {
        Text(text = "True ",fontSize = 20.sp)

    }
    Spacer(modifier = Modifier.padding(35.dp))
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp),
        shape = CircleShape,
        colors = buttonColors(
            backgroundColor = Color.Red,
            contentColor = Color.Black
        )
    ) {
        Text(text = "False",fontSize = 20.sp)

    }
}

        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(10.dp),
                shape = CircleShape,
                colors = buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                border = BorderStroke(0.7.dp, colorResource(id = R.color.black))
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = colorResource(id = R.color.teal_200)
                    )
                    Text(text = "Previous",fontSize = 15.sp)
                }

            }
            Spacer(modifier = Modifier.padding(45.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(10.dp),
                shape = CircleShape,
                colors = buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                ),
                border = BorderStroke(0.7.dp, colorResource(id = R.color.black))
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Next",fontSize = 15.sp)
                    Icon(
                       imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = colorResource(id = R.color.teal_200)
                    )

                }


            }
        }

    }
}
}

@Preview
@Composable
fun QuizScreenPreview(){
    QuizScreen(questions = listOf())
}