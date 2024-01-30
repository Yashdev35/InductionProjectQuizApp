package com.example.iitipclubprojectquizapp.data


data class QuestionObj(
    val question : String,
    val answer : Boolean
)

data class QuestionObjResponse(
    val questions : List<QuestionObj>
)

