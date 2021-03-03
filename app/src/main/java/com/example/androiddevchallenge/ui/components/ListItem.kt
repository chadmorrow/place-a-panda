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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.model.Panda
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun ListItem(onClick: (Panda) -> Unit, item: Panda) {
    Row(
        modifier = Modifier
            .clickable { onClick(item) }
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column {
            GlideImage(
                data = item.image,
                fadeIn = true,
                contentDescription = item.name,
                requestBuilder = {
                    apply(
                        RequestOptions()
                            .override(300)
                            .centerCrop()
                    )
                }
            )
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Text(item.name, style = MaterialTheme.typography.h5)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Chip(text = "${item.age} yrs old")
                Chip(text = item.sex)
            }
        }
    }
}
