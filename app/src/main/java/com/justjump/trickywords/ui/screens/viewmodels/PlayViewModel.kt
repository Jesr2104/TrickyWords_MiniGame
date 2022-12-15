package com.justjump.trickywords.ui.screens.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayViewModel @Inject constructor() : ViewModel() {

    private val _stepsGame = MutableLiveData<Int>()
    val stepsGame: LiveData<Int> = _stepsGame

    private val _countdownStart = MutableLiveData<String>()
    val countdownStart: LiveData<String> = _countdownStart

    private var _count = 3

    // setter of the step game status
    fun changeStepsGame(newStep: Int) {
        _stepsGame.value = newStep
    }

    // function to show the counter to start
    fun startCountdown(onFinish: () -> Unit) {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (_count == 0) {
                _countdownStart.value = "Start"
            } else {
                _countdownStart.value = "$_count"
            }
            if (_count == -1){
                onFinish()
            }
            _count--
        },1000)
    }
}