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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.getPandaById

@Composable
fun Detail(
    id: Int,
    onNavigateBack: () -> Unit
) {
    val panda = remember { getPandaById(id) }

    val image = painterResource(panda.image)
    val density = LocalDensity.current.density
    val width = remember { mutableStateOf(0f) }
    val height = remember { mutableStateOf(0f) }
    Box(
        Modifier
            .padding(16.dp, 8.dp)
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = MaterialTheme.colors.secondary,
            elevation = 4.dp
        ) {
            Box {
                Image(
                    image,
                    panda.name,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .aspectRatio(2f)
                        .onGloballyPositioned {
                            width.value = it.size.width / density
                            height.value = it.size.height / density
                        },
                    contentScale = ContentScale.Crop,
                )
                Column(
                    Modifier
                        .size(width.value.dp, height.value.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Black),
                                image.intrinsicSize.height * 0.6F,
                                image.intrinsicSize.height * 1F
                            )
                        )
                ) {}
                Text(
                    text = panda.name,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp),
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
            }
        }
    }
}
