package com.helder.mysoothe

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DataResource(
    @DrawableRes val imageResource: Int,
    @StringRes val text: Int
)
