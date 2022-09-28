package com.bloom.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OutTextField(
    onValueChanged: (String) -> Unit,
    paddingValues: PaddingValues,
    placeholderText: String,
    leadingIcon: (@Composable () -> Unit)?
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(paddingValues)
            .defaultMinSize(minHeight = 56.dp)
            .fillMaxWidth(),
        value = "",
        onValueChange = onValueChanged,
        placeholder = {
            Row(
                modifier = Modifier.height(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = placeholderText,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1,
                )
            }
        },
        leadingIcon = leadingIcon
    )
}