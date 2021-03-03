/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.ThemeSwitcher

@Composable
fun TopBar(text: String? = null, navigate: (() -> Unit)? = null) {
    val switchTheme = ThemeSwitcher(isSystemInDarkTheme()).switchTheme
    if (navigate != null) {
        TopAppBar(
            title = { AppBarText(text) },
            navigationIcon = { AppBarNavIcon(navigate) },
            actions = { ThemeSwitchIcon(switchTheme = switchTheme) }
        )
    } else {
        TopAppBar(
            title = { AppBarText(text) },
            actions = { ThemeSwitchIcon(switchTheme = switchTheme) }
        )
    }

}

@Composable
fun AppBarText(text: String?) {
    Text(text ?: "Place a Panda", style = MaterialTheme.typography.h6)
}

@Composable
fun AppBarNavIcon(onClick: () -> Unit) {
    Icon(
        Icons.Default.ArrowBack,
        "navButton",
        modifier = Modifier
            .size(48.dp, 48.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),
    )
}