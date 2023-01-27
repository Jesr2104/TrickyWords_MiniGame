package com.justjump.trickywords.ui.components.test

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@ExperimentalAnimationApi
@Composable
fun AnimationConunter(
    count: Int,
    modifier: Modifier = Modifier,
    style: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.body1
) {

    var oldCount by remember { mutableStateOf(count) }
    SideEffect { oldCount = count }

    Row(
        modifier = modifier
    ) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()

        for (item in countString.indices){
            val oldChar = oldCountString.getOrNull(item)
            val newChar = countString[item]
            val char = if (oldChar == newChar){
                oldCountString[item]
            } else {
                countString[item]
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    slideInVertically { it } with slideOutVertically { -it }
                }
            ){
                Text(
                    text = char.toString(),
                    style = style,
                    softWrap = false
                )
            }
        }
    }

}