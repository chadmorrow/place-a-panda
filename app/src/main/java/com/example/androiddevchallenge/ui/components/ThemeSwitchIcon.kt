package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ThemeSwitchIcon(switchTheme: () -> Unit) {
    Icon(
        if (isSystemInDarkTheme()) Icons.Outlined.LightMode else Icons.Outlined.DarkMode,
        "themeSwitcher",
        modifier = Modifier
            .size(48.dp, 48.dp)
            .padding(8.dp)
            .clickable(onClick = switchTheme),
    )
}
