package com.bloom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bloom.R
import com.bloom.components.RoundedButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WelcomeScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = MaterialTheme.colors.primary)

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
        WelcomePrimaryBackground()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { WelcomeSecondaryBackground() }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    BloomLogo()
                    BloomDescription()
                    CreateAccountButton()
                    Spacer(modifier = Modifier.height(8.dp))
                    LoginTextButton()
                }
            }
        }
    }
}

@Composable
private fun WelcomePrimaryBackground() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_light_welcome_bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun WelcomeSecondaryBackground() {
    Image(
        modifier = Modifier
            .padding(top = 72.dp)
            .offset(x = 88.dp)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.ic_light_welcome_illos),
        contentDescription = null,
        contentScale = ContentScale.Inside
    )
}

@Composable
private fun BloomLogo() {
    Image(
        painter = painterResource(id = R.drawable.ic_light_logo),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BloomDescription() {
    Text(
        modifier = Modifier.padding(top = 32.dp),
        text = "Beautiful home garden solutions",
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
private fun CreateAccountButton() {
    RoundedButton(
        onclick = { /*TODO*/ },
        paddingValues = PaddingValues(start = 8.dp, end = 8.dp, top = 40.dp),
        text = "Create Account"
    )
}

@Composable
private fun LoginTextButton() {
    TextButton(modifier = Modifier.padding(top = 8.dp), onClick = { /*TODO*/ }) {
        Text(
            text = "Log in",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.button
        )
    }
}