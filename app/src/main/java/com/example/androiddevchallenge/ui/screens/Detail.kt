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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.model.Panda
import com.example.androiddevchallenge.ui.components.Chip
import com.example.androiddevchallenge.ui.components.TopBar

import dev.chrisbanes.accompanist.glide.GlideImage
import java.util.*

@Composable
fun Detail(
    panda: Panda,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(panda.name, onNavigateBack)
        },
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GlideImage(
                    data = panda.image,
                    fadeIn = true,
                    contentDescription = panda.name,
                    requestBuilder = {
                        apply(
                            RequestOptions().centerCrop()
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f),
                    contentScale = ContentScale.Crop,
                )
                Button(modifier = Modifier.fillMaxWidth().padding(4.dp), onClick = {}) {
                    Text("Adopt ${panda.name}".toUpperCase(Locale.ROOT), color = MaterialTheme.colors.onPrimary)
                }
                Column(modifier = Modifier.padding(8.dp)) {
                    Row {
                        Text(panda.name, style = MaterialTheme.typography.h3)

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Chip(text = "${panda.age} yrs old")
                        Chip(text = panda.sex)
                    }
                    Spacer(modifier = Modifier.height(18.dp))

                    panda.loves.forEach {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Filled.Favorite,
                                "loves",
                                modifier = Modifier
                                    .size(24.dp, 24.dp)
                                    .padding(4.dp),
                                tint = Color.Red
                            )
                            Text(it)
                        }
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    panda.hates.forEach {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Filled.NotInterested,
                                "hates",
                                modifier = Modifier
                                    .size(24.dp, 24.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colors.onSurface
                            )
                            Text(it)
                        }
                    }


                }


            }

        }
    )
}

