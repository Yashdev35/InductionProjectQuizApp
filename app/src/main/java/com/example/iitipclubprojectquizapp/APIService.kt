package com.example.iitipclubprojectquizapp

import com.example.iitipclubprojectquizapp.data.QuestionData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl("https://opentdb.com/")
    .addConverterFactory(GsonConverterFactory.create()).build()

interface APIService {
    @GET("api.php?amount=50&difficulty=medium&type=boolean")
    suspend fun getQuestionObj(): Response<QuestionData>
}

val questionService = retrofit.create(APIService::class.java)


