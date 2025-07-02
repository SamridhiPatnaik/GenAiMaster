import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import android.content.Context
import android.annotation.SuppressLint
import androidx.compose.ui.platform.LocalContext
import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import com.google.accompanist.permissions.isGranted
import android.location.Location
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.SmartReplyAppTheme
import kotlinx.coroutines.launch
import kotlin.math.log

//Notifications

object NotificationUnits {
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT.= Build . VERSION_CODES .0) {
            val channel = NotificationChannel(
                "default_channel",
                "Default Channel",
                NotficationManager.IMPORTANCE_HIGH
            ).apply {
                description = "This is the default channel"
            }
            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    fun_showNotification(context: Context, title: String, message: String)
    {
        val builder = NotificationCompat.Builder(context, "default_channel")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationCompat.from(context)) {
            notify(1001, builder.build())

        }
    }
}

@Composable
fun LocalNotificatiionScreen(context: Context) {
    Column {
        Button(onClick = {
            NotificationUnits.createNotificationChannel(context)
            NotificationUnits.showNotification(context, "Hello", "This is a test notification")
        }) {
            Text("Create Notification Channel")
        }
    }
}

//@Composable
//fun CreateAccountScreen1() {
//    var firstName by remember { mutableStateOf("") }
//    var lastName by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 24.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ) {
//        Spacer(modifier = Modifier.height(80.dp))
//
//        Text(
//            text = "Create Account",
//            fontSize = 32.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black,
//            modifier = Modifier.padding(bottom = 32.dp)
//        )
//
//        val fieldModifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp)
//
//        val textFieldStyle = TextStyle(
//            fontSize = 18.sp,
//            color = Color.Black
//        )
//
//        val textFieldColors = OutlinedTextFieldDefaults.colors(
//            focusedBorderColor = Color(0xFF9B6EF3),
//            unfocusedBorderColor = Color.Gray,
//            focusedLabelColor = Color(0xFF9B6EF3),
//            unfocusedLabelColor = Color.Gray,
//            cursorColor = Color.Black,
//            focusedTextColor = Color.Black,
//            unfocusedTextColor = Color.Black,
//            focusedContainerColor = Color.White,
//            unfocusedContainerColor = Color.White
//        )
//
//        OutlinedTextField(
//            value = firstName,
//            onValueChange = { firstName = it },
//            label = { Text("name", fontSize = 16.sp) },
//            modifier = fieldModifier,
//            textStyle = textFieldStyle,
//            colors = textFieldColors
//        )

//        OutlinedTextField(
//            value = lastName,
//            onValueChange = { lastName = it },
//            label = { Text("lastname", fontSize = 16.sp) },
//            modifier = fieldModifier,
//            textStyle = textFieldStyle,
//            colors = textFieldColors
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("email", fontSize = 16.sp) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//            modifier = fieldModifier,
//            textStyle = textFieldStyle,
//            colors = textFieldColors
//        )
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password", fontSize = 16.sp) },
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            modifier = fieldModifier,
//            textStyle = textFieldStyle,
//            colors = textFieldColors
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(
//            onClick = { /* TODO: handle create account */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp),
//            shape = RoundedCornerShape(28.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9B6EF3))
//        ) {
//            Text(
//                text = "Continue",
//                color = Color.White,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Medium
//            )
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Text(
//            buildAnnotatedString {
//                append("Forgot Password? ")
//                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
//                    append("Reset")
//                }
//            },
//            fontSize = 16.sp,
//            color = Color.Black,
//            modifier = Modifier.clickable { /* TODO: handle reset */ }
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CreateAccountScreenPreview1() {
//    CreateAccountScreen1()
//}

Location
@SuppressLint("MissingPermission")
fun getCurrentLocation(context: Context, onLocationReceived: (Location?) -> Unit){
    val locationClient = LocationServices.getFusedLocationProviderClient(context)
    locationClient.lastLocation.addOnSuccessListener { location ->
        onLocationReceived(location)
    }
        .addOnFailureListener {
            onLocationReceived(null)
        }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationFetcher(context: Context = LocalContext.current,onContinueClick : () -> Unit = {}) {
    var locationByText by remember { mutableStateOf("Location : Unknown") }
    LaunchedEffect(true) {
        getCurrentLocation(context) { location ->
            location?.let {
                locationByText = "Lat : ${it.latitude}, Long : ${it.longitude}"
            }
        }
    }


    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Request Location Permission")
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            permissionState.launchPermissionRequest()
        }) {
            Text("Allow Location Access")
        }
        if (permissionState.status.isGranted) {
            Text("Permission Granted")
        } else {
            Text("Permission Not Granted")
        }
        Column(modifier = Modifier.padding(30.dp)) {
            Text(locationByText)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        locationByText?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onContinueClick,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADCFFF)) // Light blue
            ) {
                Text(
                    text = "Continue",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}



//Location Continue
//@SuppressLint("MissingPermission")
//fun getCurrentLocation(context: Context, onLocationReceived: (Location?) -> Unit) {
//    val locationClient = LocationServices.getFusedLocationProviderClient(context)
//    locationClient.lastLocation
//        .addOnSuccessListener { location ->
//            onLocationReceived(location)
//        }
//        .addOnFailureListener {
//            onLocationReceived(null)
//        }
//}
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun LocationFetcher(
//    context: Context = LocalContext.current,
//    onContinueClick: () -> Unit = {} // optional
//) {
//    var locationText by remember { mutableStateOf<String?>(null) }
//    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
//
//    // Request permission automatically on first launch
//    LaunchedEffect(Unit) {
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    // Fetch location only once permission is granted
//    LaunchedEffect(permissionState.status.isGranted) {
//        if (permissionState.status.isGranted) {
//            getCurrentLocation(context) { location: Location? ->
//                location?.let {
//                    locationText = "Lat: ${it.latitude}, Long: ${it.longitude}"
//                }
//            }
//        }
//    }
//
//
//
//    // Show location and continue button only after fetching
//    if (locationText != null) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = locationText!!,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier.height(32.dp))
//            Button(
//                onClick = onContinueClick,
//                shape = RoundedCornerShape(20.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADCFFF)) // Soft blue
//            ) {
//                Text("Continue", color = Color.Black, fontWeight = FontWeight.Bold)
//            }
//        }
//    }
//}


//Smart Replies Integration
//data class Message(val text: String, val isUser: Boolean, val timestamp: Long = System.currentTimeMillis())
//
//class MainActivity : ComponentActivity() {
//    @SuppressLint("RestrictedApi")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            SmartReplyAppTheme {
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    SmartReplyScreen()
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SmartReplyScreen() {
//    val messages = remember { mutableStateListOf<Message>() }
//    var messageInput by remember { mutableStateOf("") }
//    val smartReplies = remember { mutableStateListOf<String>() }
//
//    // Initialize SmartReply client
//    val smartReply = FirebaseNaturalLanguage.getInstance().smartReply
//
//    // Function to analyze messages and get smart replies
//    val analyzeMessagesAndGetSmartReplies: (List<Message>) -> Unit = { currentMessages ->
//        val conversation = mutableListOf<FirebaseTextMessage>()
//        currentMessages.forEach { message ->
//            if (message.isUser) {
//                conversation.add(FirebaseTextMessage.createForLocalUser(message.text, message.timestamp))
//            } else {
//                conversation.add(FirebaseTextMessage.createForRemoteUser(message.text, message.timestamp, "remoteUser123")) // Use a consistent remote user ID
//            }
//        }
//
//        smartReply.suggestReplies(conversation)
//            .addOnSuccessListener { result ->
//                smartReplies.clear()
//                if (result.suggestions.isNotEmpty()) {
//                    result.suggestions.forEach { suggestion ->
//                        smartReplies.add(suggestion.text)
//                    }
//                } else {
//                    smartReplies.add("No smart replies found.")
//                }
//            }
//            .addOnFailureListener { e ->
//                smartReplies.clear()
//                smartReplies.add("Error getting replies: ${e.localizedMessage}")
//            }
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("Smart Reply Demo") })
//        },
//        content = { paddingValues ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//            ) {
//                // Messages Display Area
//                LazyColumn(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(horizontal = 8.dp),
//                    reverseLayout = true // To show latest messages at the bottom
//                ) {
//                    items(messages.reversed()) { message -> // Display in reverse order for chat-like view
//                        MessageBubble(message = message)
//                    }
//                }
//
//                // Smart Replies Section
//                if (smartReplies.isNotEmpty()) {
//                    FlowRow(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        mainAxisSpacing = 8.dp,
//                        crossAxisSpacing = 8.dp
//                    ) {
//                        smartReplies.forEach { reply ->
//                            AssistChip(
//                                onClick = {
//                                    // When a smart reply is clicked, add it as a user message
//                                    messages.add(Message(reply, true))
//                                    // Clear existing replies or analyze again if needed
//                                    smartReplies.clear()
//                                    // Simulate a remote user reply after a smart reply is sent by the user
//                                    if (reply == "Yes, please!") {
//                                        messages.add(Message("Great! What time works for you?", false))
//                                    } else if (reply == "Sounds good!") {
//                                        messages.add(Message("See you then!", false))
//                                    }
//                                    analyzeMessagesAndGetSmartReplies(messages.toList()) // Re-analyze after new message
//                                },
//                                label = { Text(reply) }
//                            )
//                        }
//                    }
//                    Divider(modifier = Modifier.padding(horizontal = 8.dp))
//                }
//
//
//                // Message Input Area
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    OutlinedTextField(
//                        value = messageInput,
//                        onValueChange = { messageInput = it },
//                        label = { Text("Type a message") },
//                        modifier = Modifier.weight(1f),
//                        singleLine = true
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Button(
//                        onClick = {
//                            if (messageInput.isNotBlank()) {
//                                // Add user message
//                                messages.add(Message(messageInput, true))
//                                messageInput = ""
//                                // Simulate a remote user reply for demonstration purposes
//                                val remoteReply = when (messages.size % 3) {
//                                    0 -> "Hi there! How can I help?"
//                                    1 -> "I'm doing well, thanks for asking!"
//                                    else -> "Let me check on that for you."
//                                }
//                                messages.add(Message(remoteReply, false))
//
//                                // Trigger Smart Reply analysis after adding new messages
//                                analyzeMessagesAndGetSmartReplies(messages.toList())
//                            }
//                        },
//                        enabled = messageInput.isNotBlank()
//                    ) {
//                        Icon(Icons.Filled.Send, contentDescription = "Send")
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun MessageBubble(message: Message) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp),
//        horizontalArrangement = if (message.isUser) Arrangement.End else Arrangement.Start
//    ) {
//        Card(
//            shape = RoundedCornerShape(8.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = if (message.isUser) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer,
//                contentColor = if (message.isUser) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSecondaryContainer
//            )
//        ) {
//            Text(
//                text = message.text,
//                modifier = Modifier.padding(8.dp)
//            )
//        }
//    }
//}


//OpenAPI's Integration
data class Content(val type: String, val text: String)
data class MessageGPT(val role: String, val content: List<Content>)

data class ChatRequest(
    val model: String ="gpt-4.1",
    val input: String
)

data class Choice(val message:MessageGPT)

data class ChatResponse(val choices: List<MessageGPT>)

//Interface
interface OpenAIService {
    @POST("v1/responses")
    suspend fun getChatResponse(
        @Body request: ChatRequest,
        @Header("Authorization") token: String = "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"
    ): ChatResponse

}
object RetrofitClient {
    private  val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api : OpenAIService = retrofit.create(OpenAIService::class.java)
}

//viewModel

class ChatViewModel : ViewModel() {
    var responseText by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun sendMessage(userMessage: String) {
        viewModelScope.launch {
            isloading = true
            val request = ChatRequest(
                input = userMessage
               // messages = listOf(MessageGPT("user", userMessage)),
            )
            try {
                val response = RetrofitClient.api.getChatResponse(
                    request = request,
                    token = "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"
                )
                log.v("OPENAI",response.toString())
                responseText = response.body()?.choices?.firstOrNull()?.content?.firstOrNull().text ?: "No response Found"
            } catch (e: Exception) {
                responseText = "Error : ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}

//view
@Composable
fun GPTChatScreen(viewModel : ChatViewModel = viewModel()) {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(30.dp)
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TextField(
            value = inputText,
            onValueChange = {inputText = it},
            label = {Text("Type your message")},
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.sendMessage(inputText)
            },modifier = Modifier.fillMaxWidth()){
            Text("Send")
            }
    }
}