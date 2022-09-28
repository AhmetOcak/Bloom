package com.bloom.data.models

data class GardenItem(
    val id: Int,
    val text: String,
    val description: String = "This is description"
)