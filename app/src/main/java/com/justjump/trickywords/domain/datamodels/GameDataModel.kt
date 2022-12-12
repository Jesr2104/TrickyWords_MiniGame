package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDataModel(
    var bookNumber: Int = 0,
    var difficult: Int = 0
): Parcelable