package com.show.drawable

import android.content.res.ColorStateList
import android.graphics.Color


enum class Shape {

    RECTANGLE, OVAL, LINE
}


class ShapeBuilder(val shape: Shape) {

    private var cornerRadius = FloatArray(8)

    private var colorBuilder = ColorStaticListsBuilder()

    private var gradientBuilder = GradientBuilder()

    private var strokeWidth = 0

    private var dashGap = 0f

    private var dashWidth = 0f

    private var sizeWidth = -1

    private var sizeHeight = -1

    private var angle = 0f

    private var innerRadiusRatio = 0f
    private var thicknessRatio = 0f

    fun corner(radius: Float) {
        cornerRadius = floatArrayOf(radius, radius, radius, radius, radius, radius, radius, radius)
    }

    fun corner(leftTop: Float, rightTop: Float, leftBottom: Float, rightBottom: Float) {
        cornerRadius = floatArrayOf(
            leftTop,
            leftTop,
            rightTop,
            rightTop,
            leftBottom,
            leftBottom,
            rightBottom,
            rightBottom
        )
    }

    fun stroke(width: Int, color: ColorStateList) {
        this.strokeWidth = width
        colorBuilder.strokeColor(color)
    }


    fun stroke(width: Int, color: String) {
        this.strokeWidth = width
        colorBuilder.strokeColor(Color.parseColor(color))
    }

    fun stroke(width: Int, color: Int) {
        this.strokeWidth = width
        colorBuilder.strokeColor(color)
    }

    fun dash(dashGap: Float, dashWidth: Float) {
        this.dashGap = dashGap
        this.dashWidth = dashWidth
    }

    fun solid(color: Int) {
        colorBuilder.solid(color)
    }

    fun solid(color: String) {
        colorBuilder.solid(Color.parseColor(color))
    }

    fun solid(color: ColorStateList) {
        colorBuilder.solid(color)
    }

    fun size(width: Int, height: Int) {
        sizeWidth = width
        sizeHeight = height
    }


    fun gradient(
        angle: Float,
        startColor: Int,
        centerColor: Int,
        endColor: Int,
        config: (GradientBuilder.() -> Unit)? = null
    ) {
        this.angle = angle
        colorBuilder.gradient(startColor, centerColor, endColor)
        config?.invoke(gradientBuilder)
    }

    fun gradient(
        angle: Float,
        startColor: String,
        centerColor: String,
        endColor: String,
        config: (GradientBuilder.() -> Unit)? = null
    ) {
        this.angle = angle
        colorBuilder.gradient(
            Color.parseColor(startColor),
            Color.parseColor(centerColor),
            Color.parseColor(endColor)
        )
        config?.invoke(gradientBuilder)
    }

    fun gradient(angle: Float, startColor: Int, endColor: Int) {
        this.angle = angle
        colorBuilder.gradient(startColor, endColor)
    }

    fun gradient(angle: Float, startColor: String, endColor: String) {
        this.angle = angle
        colorBuilder.gradient(Color.parseColor(startColor), Color.parseColor(endColor))
    }

    fun colorStaticList(config: CreateColorStaticList.() -> Unit): ColorStateList {
        val creator = CreateColorStaticList()
        config.invoke(creator)
        return creator.create()
    }

    fun innerRadiusRatio() = innerRadiusRatio
    fun thicknessRatio() = thicknessRatio
    fun gradientBuilder() = gradientBuilder
    fun angle() = angle
    fun sizeWidth() = sizeWidth
    fun sizeHeight() = sizeHeight
    fun dashGap() = dashGap
    fun dashWidth() = dashWidth
    fun strokeWidth() = strokeWidth
    fun colorBuilder() = colorBuilder
    fun corners() = cornerRadius
}