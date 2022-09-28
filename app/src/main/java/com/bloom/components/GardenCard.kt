package com.bloom.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GardenCard(
    title: String,
    description: String,
    imageId: Int,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 64.dp, minWidth = 64.dp)
            .height(64.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = MaterialTheme.shapes.small),
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp), Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = description,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1
                )
            }
            Box(modifier = Modifier.fillMaxWidth(), Alignment.CenterEnd) {
                Checkbox(
                    modifier = Modifier.then(Modifier.size(24.dp)),
                    checked = false,
                    onCheckedChange = onCheckedChange
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxHeight(),
            Alignment.BottomCenter
        ) {
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 72.dp))
        }
    }
}