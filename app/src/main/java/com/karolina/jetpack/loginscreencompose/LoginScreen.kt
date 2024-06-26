package com.karolina.jetpack.loginscreencompose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karolina.jetpack.loginscreencompose.ui.theme.Black
import com.karolina.jetpack.loginscreencompose.ui.theme.BlueGray
import com.karolina.jetpack.loginscreencompose.ui.theme.Roboto
import com.karolina.jetpack.loginscreencompose.ui.theme.ScreenOrientation
import com.karolina.jetpack.loginscreencompose.ui.theme.dimens

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Surface {
        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            PortraitLoginScreen()
        } else {
            PortraitLoginScreen()
        }
    }
}

@Composable
private fun LandscapeLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LoginSection()
        SocialMediaSection()
    }
}

@Composable
private fun PortraitLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LoginSection()
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
            SocialMediaSection()
        }
        Spacer(modifier = Modifier.weight(0.8f))
        CreateAccountSection()
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun ColumnScope.CreateAccountSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Text(modifier = Modifier.align(alignment = CenterHorizontally),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF94A3B8),
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Don't have account?")
            }
            withStyle(
                style = SpanStyle(
                    color = uiColor,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(" ")
                append("Create now")
            }
        })
}

@Composable
private fun SocialMediaSection() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B)),

            )
    }
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialMediaLogIn(
            modifier = Modifier.weight(1f),
            icon = R.drawable.google,
            text = "Google"
        ) {
        }
        Spacer(modifier = Modifier.width(20.dp))
        SocialMediaLogIn(
            modifier = Modifier.weight(1f),
            icon = R.drawable.facebook,
            text = "Facebook"
        ) {

        }
    }
}

@Composable
fun LoginSection() {
    LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    LoginTextField(label = "Password", trailing = "Forgot?", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }

}

@Composable
private fun TopSection() {
    val uiColor: Color = if (isSystemInDarkTheme()) Color.White else Black
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(contentAlignment = Alignment.TopCenter) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight / 2.12).dp),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = if (isSystemInDarkTheme()) ColorFilter.tint(BlueGray) else null
        )

        Row(modifier = Modifier.padding(top = (screenHeight / 9).dp)) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}