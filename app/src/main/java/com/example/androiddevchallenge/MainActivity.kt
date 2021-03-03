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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.Panda
import com.example.androiddevchallenge.ui.screens.Detail
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.theme.PandaTheme

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Detail : Screen(route = "detail")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PandaTheme {
                PlaceAPanda()
            }
        }
    }
}

// Start building your app here!
@Composable
fun PlaceAPanda() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) {
                Home(
                    onClick = { panda ->
                        navController.currentBackStackEntry
                            ?.arguments?.putParcelable("panda", panda)
                        navController.navigate("${Screen.Detail.route}/${panda.id}")
                    }
                )
            }
            composable(
                route = "${Screen.Detail.route}/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val panda = navController.previousBackStackEntry?.arguments?.getParcelable<Panda>("panda")
                if (panda != null) {
                    Detail(
                        panda = panda
                    ) { navController.navigateUp() }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PandaTheme {
        PlaceAPanda()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PandaTheme(darkTheme = true) {
        PlaceAPanda()
    }
}
