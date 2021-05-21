package com.show.drawable

import android.graphics.drawable.GradientDrawable
import androidx.annotation.FloatRange
import androidx.annotation.IntRange

class GradientBuilder {

    @FloatRange(from = 0.0,to = 1.0)
    var gradientCenterX = 0.5f
    @FloatRange(from = 0.0,to = 1.0)
    var gradientCenterY = 0.5f
    var gradientType = GradientDrawable.LINEAR_GRADIENT

}