package com.show.drawable

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import java.lang.Exception
import kotlin.math.roundToInt

object DrawableBuild {

    fun build(builder: ShapeBuilder): Drawable {
        val shape = builder.shape
        val color = builder.colorBuilder()


        val drawable = GradientDrawable()
        drawable.shape = when (shape) {
            Shape.RECTANGLE -> GradientDrawable.RECTANGLE
            Shape.OVAL -> GradientDrawable.OVAL
            Shape.LINE -> GradientDrawable.LINE
        }

        //stroke
        drawable.setStroke(
            builder.strokeWidth(),
            color.strokeColor,
            builder.dashWidth(),
            builder.dashGap()
        )

        //size
        if (builder.sizeWidth() > 0 && builder.sizeHeight() > 0) {
            drawable.setSize(builder.sizeWidth(), builder.sizeHeight())
        }


        if (color.isSolid) {
            drawable.color = color.defaultColor
        }else if(color.isGradient){
            drawable.colors = color.colorsArray
            drawable.orientation = when ((builder.angle() % 360).roundToInt()) {
                45 -> GradientDrawable.Orientation.BL_TR
                90 -> GradientDrawable.Orientation.BOTTOM_TOP
                135 -> GradientDrawable.Orientation.BR_TL
                180 -> GradientDrawable.Orientation.RIGHT_LEFT
                225 -> GradientDrawable.Orientation.TR_BL
                270 -> GradientDrawable.Orientation.TOP_BOTTOM
                315 -> GradientDrawable.Orientation.TL_BR
                0 -> GradientDrawable.Orientation.LEFT_RIGHT
                else -> GradientDrawable.Orientation.LEFT_RIGHT
            }
            drawable.setGradientCenter(
                builder.gradientBuilder().gradientCenterX,
                builder.gradientBuilder().gradientCenterY
            )
            drawable.gradientType = builder.gradientBuilder().gradientType
        }

        val corners = builder.corners()
        drawable.cornerRadii = corners


        return drawable
    }
}

inline val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this,
        Resources.getSystem().displayMetrics
    )