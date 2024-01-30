package com.example.iitipclubprojectquizapp

sealed class Screen(val route: String) {
    object QuizPage : Screen("quiz_screen")
    object LandingScreen : Screen("result_screen")
}