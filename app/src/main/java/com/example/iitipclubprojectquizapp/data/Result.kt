package com.example.iitipclubprojectquizapp.data

data class Result(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: List<String>,

)