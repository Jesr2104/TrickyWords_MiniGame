package com.justjump.trickywords.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBarComp(
    title: String? = null,
    navigationIcon: ImageVector? = Icons.Filled.ArrowBack,
    onClickToBack: () -> Unit,
) {
    TopAppBar(
        title = {
            if (title != null) {
                Text(title)
            } else {
                Text("")
            }
        },
        navigationIcon = {
            IconButton(onClick = { onClickToBack() }) {
                Icon(navigationIcon!!, "Button go back")
            }
        }
    )
}