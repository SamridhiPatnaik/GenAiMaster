package com.example.my_jetpack_application.ui.theme

import CreateAccountScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            My_Jetpack_ApplicationTheme {
               LocalNotifcatioScreen(this)
            }
        }
    }
}



//FIRESTORE

data class SiliconStudent(
    val name: String = "",
    val lastname : String ="",
    val email: String = ""
)

object FireBaseRepository {
    private val db = FirebaseFirestore.getInstance()
    private val studentsCollection = db.collection("students")

    fun addStudent(student: SiliconStudent, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        studentsCollection.add(student)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

}


class StudentViewModel : ViewModel() {
    fun addStudent(name: String, lastname: String, email: String) {
        FireBaseRepository.addStudent(SiliconStudent(name, lastname, email), {}, {})
    }
}



@Composable
fun StudentScreen(viewModel: StudentViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Add Student Screen", fontSize = 20.sp)
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        OutlinedTextField(
            value = lastname,
            onValueChange = { lastname = it },
            label = { Text("LastName") })
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") })
        Button(onClick = {
            if (name.isNotEmpty() && lastname.isNotEmpty() && email.isNotEmpty()) {
                viewModel.addStudent(name, lastname, email)
                name = ""
                lastname = ""
                email = ""
            }
        }) {
            Text("Add ")
        }
    }
}

//Smart Reply Integration

