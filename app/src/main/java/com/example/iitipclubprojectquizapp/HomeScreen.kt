package com.example.iitipclubprojectquizapp

import android.util.Log
import android.view.Gravity
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.iitipclubprojectquizapp.data.QuestionAndAns
import com.example.iitipclubprojectquizapp.data.listOfQuestion
@Composable
fun QuizScreen(
    listOfQuestion: List<QuestionAndAns>,
    navController : NavController
){
    //the screen which contains the quiz, it takes the list of questions and the nav controller as parameters
    //mutable state changes the value of the variable and recomposes the screen
    val userAns = remember { mutableStateOf(true) }
    val currentQuestion = remember { mutableStateOf(0) }
    val context = LocalContext.current
    val score = remember { mutableStateOf(0) }
    fun updateQuestion(){
        //this function is makes sure that the question number doesn't go out of bounds
        if(currentQuestion.value>=0 && currentQuestion.value <= listOfQuestion.size - 1){
           Log.d("TAG", "updateQuestion: ${currentQuestion.value}")
        }else{
            if(currentQuestion.value > listOfQuestion.size - 1){
                currentQuestion.value--
                val completeToast =Toast.makeText(context,"Quiz Completed",Toast.LENGTH_SHORT)
                completeToast.setGravity(Gravity.TOP,0,0)
                completeToast.show()
            }else{
                currentQuestion.value++
                val really = Toast.makeText(context,"Really?",Toast.LENGTH_SHORT)
                really.setGravity(Gravity.TOP,0,0)
                really.show()
            }
        }
    }
    fun checkAns(){
        //this function checks the answer and updates the score accordingly
        if(userAns.value == listOfQuestion[currentQuestion.value].trueAns){
            currentQuestion.value++
            updateQuestion()
            if(score.value>=0 && score.value < listOfQuestion.size){
                score.value++
            }else{
                score.value--
                val onceAnsToast = Toast.makeText(context,"Ans one question once,Please",Toast.LENGTH_SHORT)
                onceAnsToast.setGravity(Gravity.TOP,0,0)
                onceAnsToast.show()
            }
            val correctToast = Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT)
            correctToast.setGravity(Gravity.START,25,25)
            correctToast.show()
        }else{
            currentQuestion.value++
            updateQuestion()
            if(score.value>0 && score.value < listOfQuestion.size){
                score.value--
            }else{
                score.value++
                val ayeNoob = Toast.makeText(context,"AYE NOOB! A free point so that you don't go -ve",Toast.LENGTH_LONG)
                ayeNoob.setGravity(Gravity.TOP,0,0)
                ayeNoob.show()
            }
            val wrongToast = Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT)
            wrongToast.setGravity(Gravity.TOP,0,0)
            wrongToast.show()
        }
    }
    //S
    Scaffold(
topBar = {
AppBar(title = "Quiz"){
navController.popBackStack()
}

},
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    elevation = 10.dp,
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(100.dp),
                    border = BorderStroke(1.dp, color = Color.White)

                ){
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "Score: ${score.value}/${listOfQuestion.size}",fontSize = 20.sp,fontWeight = FontWeight.Bold,color = Color.Black)
                    }

                }
            }
        }
){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = colorResource(id = R.color.black)),
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
                            text = "Answer correctly for 1 point and wrong answer will cost 1, be careful.",
                            style = TextStyle(
                                color = colorResource(id = R.color.white),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            ),
                            textAlign = TextAlign.Center
                        )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "As you can see the questions are true or false type so you know the drill",
                        style = TextStyle(
                            color = colorResource(id = R.color.white),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        textAlign = TextAlign.Center
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
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(0.7.dp, colorResource(id = R.color.white))
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
                            tint = colorResource(id = R.color.teal_200),
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Text(text = "Back",fontSize = 15.sp,color = colorResource(id = R.color.white))
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
                        backgroundColor = Color.Black,
                        contentColor = Color.White,
                    ),
                    border = BorderStroke(0.7.dp, colorResource(id = R.color.white))
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Next",fontSize = 15.sp,color = colorResource(id = R.color.white))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = colorResource(id = R.color.teal_200),
                            modifier = Modifier.padding(start = 5.dp)
                        )

                    }


                }
            }


        }
}

}
//Preview functions help us to see the preview of the screen in the android studio itself
//but they don't show the actual functionality of the app, just the UI
@Preview
@Composable
fun QuizScreenPreview(){
    val navController = rememberNavController()
    QuizScreen(listOfQuestion,navController = navController)
}