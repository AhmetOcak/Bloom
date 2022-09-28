package com.bloom.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ThemesCard(text: String, imageId: Int) {
    Card(
        modifier = Modifier
            .defaultMinSize(minHeight = 136.dp, minWidth = 136.dp)
            .size(height = 136.dp, width = 136.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 1.dp,
        shape = RoundedCornerShape(4.dp),
        contentColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {
            Image(
                modifier = Modifier
                    .defaultMinSize(minHeight = 96.dp)
                    .height(96.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxSize(), Arrangement.Center) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = text,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.h2,
                )
            }
        }
    }
}