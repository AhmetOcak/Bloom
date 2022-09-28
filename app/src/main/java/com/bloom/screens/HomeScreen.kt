package com.bloom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bloom.R
import com.bloom.components.GardenCard
import com.bloom.components.OutTextField
import com.bloom.components.ThemesCard
import com.bloom.data.BloomData
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MaterialTheme.colors.background)

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            SearchField()
            BrowseThemesSection()
            Themes()
            DesignSection()
            GardenSection()
        }
    }
}

@Composable
private fun SearchField() {
    OutTextField(
        onValueChanged = {},
        paddingValues = PaddingValues(top = 40.dp, start = 16.dp, end = 16.dp),
        placeholderText = "Search",
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(start = 18.dp).size(18.dp),
                painter = painterResource(id = R.drawable.ic_baseline_search),
                contentDescription = null,
            )
        }
    )
}

@Composable
private fun BrowseThemesSection() {
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 32.dp),
        text = "Browse themes",
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.h1
    )
}

@Composable
private fun Themes() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(BloomData.themeData) { theme ->
            ThemesCard(text = theme.text, imageId = theme.id)
        }
    }
}

@Composable
private fun DesignSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Design your home garden",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h1
        )
        IconButton(
            modifier = Modifier.then(Modifier.size(24.dp)),
            onClick = {},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_filter_list),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun GardenSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(BloomData.gardenData) { garden ->
            GardenCard(
                title = garden.text,
                imageId = garden.id,
                description = garden.description,
                onCheckedChange = {}
            )
        }
    }
}