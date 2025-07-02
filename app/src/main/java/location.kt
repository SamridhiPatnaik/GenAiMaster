import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices

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

Location Continue
@SuppressLint("MissingPermission")
fun getCurrentLocation(context: Context, onLocationReceived: (Location?) -> Unit) {
    val locationClient = LocationServices.getFusedLocationProviderClient(context)
    locationClient.lastLocation
        .addOnSuccessListener { location ->
            onLocationReceived(location)
        }
        .addOnFailureListener {
            onLocationReceived(null)
        }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationFetcher(
    context: Context = LocalContext.current,
    onContinueClick: () -> Unit = {} // optional
) {
    var locationText by remember { mutableStateOf<String?>(null) }
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)


    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }


    LaunchedEffect(permissionState.status.isGranted) {
        if (permissionState.status.isGranted) {
            getCurrentLocation(context) { location: Location? ->
                location?.let {
                    locationText = "Lat: ${it.latitude}, Long: ${it.longitude}"
                }
            }
        }
    }




    if (locationText != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = locationText!!,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = onContinueClick,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADCFFF)) // Soft blue
            ) {
                Text("Continue", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}