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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.model.Panda
import com.example.androiddevchallenge.model.getPandas
import com.example.androiddevchallenge.ui.screens.Detail
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.theme.PandaTheme
import com.example.androiddevchallenge.ui.theme.ThemeSwitcher

sealed class Page(val route: String) {
    object Home : Page(route = "home")
    object Detail : Page(route = "detail")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val switchTheme = ThemeSwitcher(isSystemInDarkTheme()).switchTheme
            PandaTheme {
                PlaceAPanda(switchTheme)
            }
        }
    }
}

// Start building your app here!
@Composable
fun PlaceAPanda(switchTheme: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Page.Home.route) {
            composable(route = Page.Home.route) {
                Home(
                    navController,
                    switchTheme,
                )
            }
            composable(
                route = "${Page.Detail.route}/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { navBackStackEntry ->
                navBackStackEntry.arguments?.getInt("id")?.let { id ->
                    Detail(
                        id = id,
                        onNavigateBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val switchTheme = ThemeSwitcher(isSystemInDarkTheme()).switchTheme
    PandaTheme {
        PlaceAPanda(switchTheme)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val switchTheme = ThemeSwitcher(isSystemInDarkTheme()).switchTheme
    PandaTheme(darkTheme = true) {
        PlaceAPanda(switchTheme)
    }
}
