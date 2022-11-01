package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.justjump.trickywords.R
import com.justjump.trickywords.ui.components.TopBarComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen(onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = stringResource(R.string.title_settings),
                onClickToBack = onClickToBack)
        },
    ) { }
}