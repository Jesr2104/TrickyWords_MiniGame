package com.justjump.trickywords.ui.screens.viewmodels

import android.os.Handler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class PlayViewModel @Inject constructor(): ViewModel() {

    private val _stepsGame = MutableLiveData<Int>()
    val stepsGame: LiveData<Int> = _stepsGame

    private val _countdownStart = MutableLiveData<String>()
    val countdownStart: LiveData<String> = _countdownStart

    var count = 6

    fun changeStepsGame(newStep: Int){
        _stepsGame.value = newStep
    }

    fun startCountdown(){
        val handler = Handler()
        handler.postDelayed({
            if (count == 0){
                _countdownStart.value = "Start"
            } else {
                _countdownStart.value = "$count"
                count--
            }
        }, 1000);
    }
}