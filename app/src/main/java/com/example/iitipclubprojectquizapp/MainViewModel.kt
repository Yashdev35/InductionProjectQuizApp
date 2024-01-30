package com.example.iitipclubprojectquizapp

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.iitipclubprojectquizapp.data.QuestionData
import com.example.iitipclubprojectquizapp.data.QuestionObj
import com.example.iitipclubprojectquizapp.data.Result
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel(){
data class QuestionsState(
    val loading: Boolean = false,
    val questiondata : Response<QuestionData>? = null,
    val error: String? = null
    )
    private val _questionsState = mutableStateOf(QuestionsState())
    val questionsState: State<QuestionsState> = _questionsState

    private fun fetchQuestions(){
        viewModelScope.launch{
            try{
                val response = questionService.getQuestionObj()
                _questionsState.value = _questionsState.value.copy(
                    loading = false,
                    questiondata = response,
                    error = null
                )

            }catch(e: Exception){
                _questionsState.value = _questionsState.value.copy(
                    loading = false,
                    error = "error occured while fetching the questions ${e.localizedMessage}"
                )
            }
        }
    }
}

@Preview
@Composable
fun printQuestion(){
    val view : MainViewModel = viewModel()
    if(view.questionsState.value.questiondata?.body()==null){
        Text("gand mara")
    }else{
        Text(text = "Loading")
    }
}
//testing