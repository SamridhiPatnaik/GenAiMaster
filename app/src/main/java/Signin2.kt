import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInScreen() {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign in",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 120.dp),
            textAlign = TextAlign.Start
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0x7AA49696),
                focusedContainerColor = Color(0xF1EBEB27)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp), // Square shape
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8E6CEF),
                contentColor = Color.White
            )
        ) {
            Text(text = "Continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = "Don't have an Account? Create One",
        fontSize = 12.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 8.dp),
        textAlign = TextAlign.Center
    )

        Spacer(modifier = Modifier.height(32.dp))

        SocialButton("Continue With Apple", Color(0xFFF4F4F4))
        Spacer(modifier = Modifier.height(5.dp))
        SocialButton("Continue With Google", Color(0xFFF4F4F4))
        Spacer(modifier = Modifier.height(5.dp))
        SocialButton("Continue With Facebook", Color(0xFFF4F4F4))
    }
}

@Composable
fun SocialButton(text: String, backgroundColor: Color) {
    Button(
        onClick = { /* TODO */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(49.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.Black
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(text = text, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
