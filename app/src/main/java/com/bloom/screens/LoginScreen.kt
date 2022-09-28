package com.bloom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bloom.components.OutTextField
import com.bloom.components.RoundedButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LoginScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MaterialTheme.colors.background)

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 184.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header()
                TextFields()
                LoginDescription()
                RoundedButton(
                    onclick = { /*TODO*/ },
                    paddingValues = PaddingValues(horizontal = 16.dp),
                    text = "Log in",
                )
            }
        }
    }
}

@Composable
private fun Header() {
    Text(
        text = "Log in with email",
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.h1,
    )
}

@Composable
private fun LoginDescription() {
    Text(
        modifier = Modifier.padding(
            start = 8.dp,
            end = 8.dp,
            top = 24.dp,
            bottom = 16.dp
        ),
        text = "By Clicking below you agree to our Terms of Use and consent to our Privacy Policy.",
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun TextFields() {
    OutTextField(
        onValueChanged = {},
        paddingValues = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp),
        placeholderText = "Email address",
        leadingIcon = null
    )
    OutTextField(
        onValueChanged = {},
        paddingValues = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp),
        placeholderText = "Password (8+ characters)",
        leadingIcon = null
    )
}
