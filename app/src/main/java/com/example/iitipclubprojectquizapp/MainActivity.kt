package com.example.iitipclubprojectquizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iitipclubprojectquizapp.data.listOfQuestion
import com.example.iitipclubprojectquizapp.ui.theme.IITIPclubprojectQuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            IITIPclubprojectQuizAppTheme {
                AppNavigation()
            }
        }
    }
}
//here we define the navigation between screens using normal navigation compose
@Composable
fun AppNavigation(
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LandingScreen.route){
        composable(Screen.LandingScreen.route){
            LandingPage(
                navigateToQuizScreen = {
                    navController.navigate(Screen.QuizPage.route)
                }
            )
        }
        composable(Screen.QuizPage.route){
            QuizScreen(listOfQuestion = listOfQuestion,navController = navController)
        }
    }

}
