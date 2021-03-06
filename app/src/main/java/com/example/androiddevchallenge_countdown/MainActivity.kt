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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.EvStation
import androidx.compose.material.icons.filled.FormatAlignRight
import androidx.compose.material.icons.filled.Toys
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge_countdown.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

val viewModel = CountDownViewModel()

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        ActionScreen()
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
    ) {
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
            ) {
                Background(maxWidth = maxWidth)
                CarItem()
            }
        }
        Row(
            modifier = Modifier
                .weight(1.0f, true)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                ChargeStatus()
            }
        }
    }
}

@Composable
fun ChargeStatus() {

    val chargeCount = viewModel.chargeCount
    val activeColor = Color(0xFFF4B400)
    val inactiveColor = Color.LightGray

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 2) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 3) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 4) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 5) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 6) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 7) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 8) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 9) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 10) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 11) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 12) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 13) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 14) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 15) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 16) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 17) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 18) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 19) inactiveColor else activeColor
            )
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Icon(
                Icons.Filled.Bolt, "",
                Modifier.size(50.dp),
                tint = if (chargeCount < 20) inactiveColor else activeColor
            )
        }
    }
}

@Composable
fun Background(maxWidth: Dp) {
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

    val modifier = Modifier
        .offset(
            x = if (viewModel.isCharge) {
                maxWidth / 2
            } else {
                maxWidth * positionState.value
            }
        )

    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
    )
    {
        if (viewModel.isCharge) {
            Icon(
                Icons.Filled.EvStation, "",
                Modifier
                    .size(100.dp)
                    .offset(
                        x = (-80).dp
                    ),
                tint = Color.LightGray
            )
        } else {
            Icon(
                Icons.Filled.Business,
                "",
                Modifier.size(100.dp
                ),
                tint = Color.LightGray
            )
        }
    }
}

@Composable
fun CarItem() {
    Row(
        modifier = Modifier
            .height(75.dp)
            .width(150.dp)
    )
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
    if (viewModel.isCharge) {
        val chargeColor = animateColorAsState(
            targetValue = if (batteryState.value > 0.5) Color.White else Color(0xFFF4B400)
        )
        Icon(
            Icons.Filled.Bolt,
            "" ,
            Modifier.size(75.dp),
            tint = chargeColor.value
        )
    } else {
        val runColor = animateColorAsState(
            targetValue = if (batteryState.value > 0.5) Color.White else Color.LightGray
        )
        Icon(
            Icons.Filled.FormatAlignRight,
            "" ,
            Modifier.size(75.dp),
            tint = runColor.value
        )
    }
}

@Composable
fun Car() {
    Icon(
        Icons.Filled.Toys,
        "" ,
        Modifier.size(75.dp),
        tint = Color.White
    )
}

// ----------------------

@Composable
fun ActionScreen() {
    Row {
        Column(
            modifier = Modifier
                .weight(1.0f,
                    true
                )
                .padding(16.dp),
        ) {
            Setting()
        }
        Column(
            modifier = Modifier.weight(1.0f,
            true
        )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                ChargingAnimation()
            }
        }
        Column(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                ChargeAction()
            }
        }
    }
}


@Composable
fun Setting() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        IconButton(onClick = { viewModel.changeSettingState() },
        )
        {
            Icon(imageVector = Icons.Outlined.Settings,
                contentDescription = "setting button" ,
                modifier = Modifier.size(50.dp))
        }

        val buttonModifier = Modifier
            .width(150.dp)
            .height(50.dp)
        if (viewModel.settingButtonVisible) {
            Column(
                modifier = Modifier
                .fillMaxSize()
                .offset(
                    x = 0.dp,
                    y = 50.dp
                ),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Button(onClick = {
                    viewModel.changeChargeState(SettingChargeState.Charge5Sec)
                },
                    modifier = buttonModifier
                ) {
                    Text(text = "5 sec Charge")
                }

                Button(onClick = {
                    viewModel.changeChargeState(SettingChargeState.Charge10Sec)
                },
                    modifier = buttonModifier
                ) {
                    Text(text = "10 sec Charge")
                }

                Button(onClick = {
                    viewModel.changeChargeState(SettingChargeState.Charge15Sec)
                },
                    modifier = buttonModifier
                ) {
                    Text(text = "15 sec Charge")
                }

            }
        }
    }
}

@Composable
fun ChargeAction() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        Button(onClick = { viewModel.chargeStart() }) {
            Text(text = viewModel.chargeButtonString)
        }
    }
}

@Composable
fun ChargingAnimation() {

    if (viewModel.isCharge) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.DarkGray),
                contentAlignment = Alignment.Center,
            )
            {
                Text(
                    text = viewModel.chargeCountDownString,
                    style = MaterialTheme.typography.h3,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .size(75.dp)
                        .offset(
                            y = 10.dp
                        )
                )
            }

        }
    }
}

