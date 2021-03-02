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
package com.example.androiddevchallenge.model

import android.os.Parcelable
import com.example.androiddevchallenge.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Panda(
    val id: Int,
    val image: Int,
    val name: String,
    val age: Int,
    val sex: String,
    val loves: List<String?>,
    val hates: List<String?>,
) : Parcelable

val pandaDb = listOf(
    Panda(
        id = 0,
        image = R.drawable.panda_boop,
        name = "Sita",
        age = 3,
        sex = "Female",
        loves = listOf("Apples", "Hugs"),
        hates = listOf("Dogs", "People without apples")
    ),
    Panda(
        id = 1,
        image = R.drawable.panda_still_1,
        name = "Oolong",
        age = 4,
        sex = "Female",
        loves = listOf("Watermelon", "Snow"),
        hates = listOf("Loss of habitat to humans", "Snakes")
    ),
    Panda(
        id = 2,
        image = R.drawable.panda_still_2,
        name = "Chai",
        age = 4,
        sex = "Male",
        loves = listOf("Fruit", "Alone time"),
        hates = listOf("Yellow-throated Martens")
    ),
    Panda(
        id = 3,
        image = R.drawable.panda_still_3,
        name = "Piya",
        age = 7,
        sex = "Male",
        loves = listOf("Pouncing on friends", "Running really fast!"),
        hates = listOf("Humans", "Slippery tree branches")
    ),
    Panda(
        id = 4,
        image = R.drawable.panda_still_4,
        name = "Satya",
        age = 5,
        sex = "Female",
        loves = listOf("Bamboo", "Eating bamboo"),
        hates = listOf("Noise", "People")
    ),
    Panda(
        id = 5,
        image = R.drawable.panda_still_5,
        name = "Panna",
        age = 3,
        sex = "Male",
        loves = listOf("Quiet solitude"),
        hates = listOf("Knowing humans will kill all of us someday")
    ),
    Panda(
        id = 6,
        image = R.drawable.panda_still_8,
        name = "Sonika",
        age = 4,
        sex = "Female",
        loves = listOf("Climbing tall trees", "Cuddles", "People", "Friends"),
        hates = listOf("Nighttime")
    ),
    Panda(
        id = 7,
        image = R.drawable.panda_still_7,
        name = "Nava",
        age = 8,
        sex = "Female",
        loves = listOf("Being a firefox", "Mountains"),
        hates = listOf("Noisy humans", "Yellow-throated Martens")
    ),
    Panda(
        id = 8,
        image = R.drawable.panda_still_6,
        name = "Cini",
        age = 2,
        sex = "Male",
        loves = listOf("Apples", "Snowflakes"),
        hates = listOf("Yellow-throated Martens", "People without apples")
    ),
    Panda(
        id = 9,
        image = R.drawable.panda_eat,
        name = "Masala",
        age = 9,
        sex = "Female",
        loves = listOf("Snow", "Sleeping"),
        hates = listOf("Dogs", "Fire")
    ),
)


fun getPandas(): List<Panda> {
    return pandaDb
}

fun getPandaById(id: Int): Panda {
    val result = pandaDb.find { id == it.id }
    if (result != null) {
        return result
    } else {
        throw NoSuchElementException()
    }
}