package com.justjump.trickywords.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoPlayGame(
    val gameMode: Int,
    val bookNumber: Int,
    var difficult: Int = 0
): Parcelable