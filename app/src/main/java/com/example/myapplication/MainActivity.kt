package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Sửa lỗi typo: horizontalignment
    ){
        ProfileHeader()
        Spacer(modifier = Modifier.height(50.dp))
        ContactInfo()
    }
}

@Composable
fun ProfileHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(

            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(text = "TRAN DUONG CAT MINH", fontSize = 18.sp)
        Text(text = "SIEU CAP VIP PRO", color = Color(0xFF3DDC84))
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Phone, contentDescription = null, tint = Color(0xFF3DDC84))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "0399537781")
        }
        // Dòng mạng xã hội
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Share, contentDescription = null, tint = Color(0xFF3DDC84))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "https://www.facebook.com/catminhmtp?locale=vi_VN")
        }
        // Dòng Email
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Email, contentDescription = null, tint = Color(0xFF3DDC84))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "mt661458@gmail.com")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        BusinessCardScreen()
    }
}