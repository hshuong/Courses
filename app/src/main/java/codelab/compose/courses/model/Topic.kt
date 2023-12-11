package codelab.compose.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceName: Int,
    val number: Int,
    @DrawableRes val imageResourceId: Int,

)
