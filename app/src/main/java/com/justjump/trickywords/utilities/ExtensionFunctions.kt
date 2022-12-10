package com.justjump.trickywords.utilities

import androidx.navigation.NavHostController

fun <T> NavHostController.passOnDataSet(key: String, value: T){
    this.currentBackStackEntry?.savedStateHandle?.set(key = key, value = value)
}

inline fun <reified T> NavHostController.passOnDataGet(key: String): T? {
    return this.previousBackStackEntry?.savedStateHandle?.get<T>(key)
}

