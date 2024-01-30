package com.example.iitipclubprojectquizapp
//this seal class contains the route strings for the screens, reason for using this is to avoid typos
sealed class Screen(val route: String) {
    object QuizPage : Screen("quiz_screen")
    object LandingScreen : Screen("result_screen")
}