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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.model.Panda
import com.example.androiddevchallenge.ui.components.Chip
import com.example.androiddevchallenge.ui.components.TopBar
import dev.chrisbanes.accompanist.glide.GlideImage
import java.util.Locale

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
