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
package com.example.androiddevchallenge_countdown

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.EvStation
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.Toys
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge_countdown.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        BackGroundScreen()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun BackGroundScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
            Ground()
    }
}

@Composable
fun Ground() {
    Column {
        Row(
            modifier = Modifier.weight(4.0f, true),
            ) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter
            ){
                Wood1(maxWidth = maxWidth)
                CarItem()
            }
        }
        Row(modifier = Modifier.weight(1.0f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ){
            }
            
        }
    }
}

@Composable
fun Wood1(maxWidth: Dp) {
    val infiniteTransition = rememberInfiniteTransition()
    val positionState = infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = LinearEasing
            )
        )
    )

    val modifier = Modifier.offset(x = maxWidth * positionState.value)

    Row(modifier = modifier
        .height(75.dp)
        .fillMaxWidth()
    )
    {
        Icon(Icons.Filled.EvStation, "" , Modifier.size(75.dp), tint = Color.LightGray)
    }
}

@Composable
fun CarItem() {
    Row(modifier = Modifier
        .height(50.dp)
        .width(100.dp))
    {
        CarAnimation()
        Car()
    }
}

@Composable
fun CarAnimation() {
    val infiniteTransition = rememberInfiniteTransition()
    val batteryState = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = LinearEasing
            )
        )
    )
    val color = animateColorAsState(
        targetValue = if(batteryState.value > 0.5) Color.White else Color.Yellow
    )
    Icon(Icons.Filled.Bolt, "" , Modifier.size(50.dp), tint = color.value)
    //Icon(Icons.Filled.FormatAlignRight, "" , Modifier.size(50.dp), tint = color.value)
}

@Composable
fun Car() {
    Icon(Icons.Filled.Toys, "" , Modifier.size(50.dp), tint = Color.White)
}
