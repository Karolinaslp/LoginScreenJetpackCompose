package com.karolina.jetpack.loginscreencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.karolina.jetpack.loginscreencompose.ui.theme.LoginScreenComposeTheme

//@Preview(showBackground = true)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenComposeTheme {
                LoginScreen()
            }
        }
    }

}



