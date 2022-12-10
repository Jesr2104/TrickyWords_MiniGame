package com.justjump.trickywords.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SetGame(
    val gameMode: Int,
    val bookNumber: Int = 0,
    var difficult: Int = 0
): Parcelable