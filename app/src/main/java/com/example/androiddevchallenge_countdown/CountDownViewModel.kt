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

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

sealed class SettingButtonState {
    object Open : SettingButtonState()
    object Close : SettingButtonState()
}

sealed class SettingChargeState {

    abstract fun buttonString(): String
    abstract fun timeFuture(): Long

    companion object {
        private const val CHARGE_5SEC_STRING: String = "5 sec Charge START!"
        private const val CHARGE_10SEC_STRING: String = "10 sec Charge START!"
        private const val CHARGE_15SEC_STRING: String = "15 sec Charge START!"
    }

    object Charge5Sec : SettingChargeState() {
        override fun buttonString(): String = CHARGE_5SEC_STRING
        override fun timeFuture(): Long = 5000
    }

    object Charge10Sec : SettingChargeState() {
        override fun buttonString(): String = CHARGE_10SEC_STRING
        override fun timeFuture(): Long = 10000
    }

    object Charge15Sec : SettingChargeState() {
        override fun buttonString(): String = CHARGE_15SEC_STRING
        override fun timeFuture(): Long = 15000
    }
}

class CountDownViewModel : ViewModel(), LifecycleObserver {

    private var settingButtonState: SettingButtonState = SettingButtonState.Close
    var settingButtonVisible: Boolean by mutableStateOf(false)

    fun changeSettingState() {
        settingButtonState = when(settingButtonState) {
            SettingButtonState.Close -> {
                settingButtonVisible = true
                SettingButtonState.Open
            }
            SettingButtonState.Open -> {
                settingButtonVisible = false
                SettingButtonState.Close
            }
        }
    }

    private var chargeButtonState: SettingChargeState = SettingChargeState.Charge5Sec
    var chargeButtonString by mutableStateOf(SettingChargeState.Charge5Sec.buttonString())
    var chargeCountDownString by mutableStateOf("-")
    var isCharge by mutableStateOf(false)
    var chargeCount by mutableStateOf(5)

    fun changeChargeState(currentState : SettingChargeState) {
        chargeButtonState = currentState
        chargeButtonString = currentState.buttonString()
        changeSettingState()
    }

    fun chargeStart() {
        chargeCountDownString = "${chargeButtonState.timeFuture() / 1000}"
        isCharge = true

        val timer = object: CountDownTimer(chargeButtonState.timeFuture(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                chargeCount++
                chargeCountDownString = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                isCharge = false
            }
        }
        timer.start()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        loopTimerState = true
        loopTimerStart()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        loopTimerState = false
    }

    private var loopTimerState = true
    private var loopTimer : CountDownTimer? = null

    private fun loopTimerStart() {
        if (loopTimer != null) { return }
        loopTimer = object: CountDownTimer(3000,3000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                if (chargeCount > 1 && !isCharge) {
                    chargeCount--
                }
                Log.d("TAG","COUNT DOWN $chargeCount")
                loopTimer = null
                if (loopTimerState){
                    loopTimerStart()
                }
            }
        }
        loopTimer?.start()
    }
}