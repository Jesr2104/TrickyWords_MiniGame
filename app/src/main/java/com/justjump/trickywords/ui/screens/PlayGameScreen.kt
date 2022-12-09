package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.justjump.trickywords.ui.components.TopBarComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayGameScreen(difficultyModeValue: Int, onClickToBack: () -> Unit) {
    Scaffold(topBar = { TopBarComp(onClickToBack = onClickToBack) })
    {
        Text(text = "Nueva ventana play game Difficulty: $difficultyModeValue")
    }



    // Requerimientos para la prueba
    //-----------------------------------------------------------------------------------
    // 1. Necesitamos la difilcultad (done)
    // 2. Necesitamos el libro del que se va a hacer la prueba
    // 3. Button to go back on the app (done)
    // 4. scaffold (done)
    // 3. necesitamos realizar la consulta de las 12 preguntas del libro seleccionado
    //    y la dificulta seleccionada
    // 4. ellos se almacenaran el un array y se van a ir preguntando uno a uno hasta
    //    terminar la prueba
}