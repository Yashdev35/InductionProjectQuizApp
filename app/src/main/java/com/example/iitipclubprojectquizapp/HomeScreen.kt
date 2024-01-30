package com.example.iitipclubprojectquizapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.navigation.NavController
import com.example.iitipclubprojectquizapp.data.QuestionAndAns


@Composable
fun QuizScreen(
    listOfQuestion: List<QuestionAndAns>,
    navController : NavController
){
    val userAns = remember { mutableStateOf(true) }
    val currentQuestion = remember { mutableStateOf(0) }
    val context = LocalContext.current
    val score = remember { mutableStateOf(0) }
    fun updateQuestion(){
        if(currentQuestion.value>=0 && currentQuestion.value <= listOfQuestion.size - 1){
           Log.d("TAG", "updateQuestion: ${currentQuestion.value}")
        }else{
            if(currentQuestion.value > listOfQuestion.size - 1){
                currentQuestion.value--
                Toast.makeText(context,"Quiz Completed",Toast.LENGTH_SHORT).show()
            }else{
                currentQuestion.value++
                Toast.makeText(context,"Really?",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun checkAns(){
        if(userAns.value == listOfQuestion[currentQuestion.value].trueAns){
            currentQuestion.value++
            updateQuestion()
            if(score.value>=0 && score.value < listOfQuestion.size){
                score.value++
            }else{
                score.value--
                Toast.makeText(context,"Ans one question once,Please",Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
topBar = {
AppBar(title = "Quiz App"){
navController.popBackStack()
}
}
){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                        text = "your current score is ${score.value}/${listOfQuestion.size}",
                        style = TextStyle(
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                }
            }
            QuestionCard(
                questionList = listOfQuestion,
                currentQuestion = currentQuestion)
            Spacer(modifier = Modifier.padding(10.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
            ){
                Button(
                    onClick = {
                        userAns.value = true
                        checkAns()
                              },
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
                    onClick = {
                        userAns.value = false
                        checkAns()
                              },
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

            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {
                        currentQuestion.value--
                        updateQuestion()
                              },
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
                    onClick = {
                               currentQuestion.value++
                               updateQuestion()
                              },
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
   // QuizScreen(questions = listOfQuestion)
}