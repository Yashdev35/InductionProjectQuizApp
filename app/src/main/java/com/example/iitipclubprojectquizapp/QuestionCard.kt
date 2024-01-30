package com.example.iitipclubprojectquizapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iitipclubprojectquizapp.data.QuestionAndAns

@Composable
fun QuestionCard(
    questionList: List<QuestionAndAns>,
    currentQuestion: MutableState<Int>
){
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
        elevation = 10.dp,
        backgroundColor = Color.White
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = questionList[currentQuestion.value].question, fontWeight = FontWeight.ExtraBold,fontSize = 20.sp)
        }

    }
}


@Preview
@Composable
fun QuestionCardPreview() {
   // QuestionCard("2+2=4")
}
