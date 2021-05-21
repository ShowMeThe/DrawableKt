package com.show.drawable

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.SparseIntArray

val TR = ColorStateList.valueOf(Color.TRANSPARENT)

class ColorStaticListsBuilder {

    var isSolid = false
    var defaultColor = TR
    var strokeColor = TR
    var isGradient = false
    var colorsArray = intArrayOf()

    fun solid(color: Int) {
        defaultColor = ColorStateList.valueOf(color)
        isSolid = true
        isGradient = false
    }

    fun solid(color: ColorStateList) {
        defaultColor = color
        isSolid = true
        isGradient = false
    }

    fun strokeColor(color: Int) {
        strokeColor = ColorStateList.valueOf(color)
    }

    fun strokeColor(color: ColorStateList) {
        strokeColor = color
    }

    fun gradient(startColor:Int,centerColor:Int,endColor:Int) {
        colorsArray = intArrayOf(startColor,centerColor, endColor)
        isGradient = true
        isSolid = false
    }

    fun gradient(startColor:Int,endColor:Int) {
        colorsArray = intArrayOf(startColor, endColor)
        isGradient = true
        isSolid = false
    }

}

class CreateColorStaticList {
    private val array = SparseIntArray()

    private var defaultColor = Color.TRANSPARENT
    fun default(color: Int) {
        defaultColor = color
    }

    fun pressed(color: Int) {
        val pressed = android.R.attr.state_pressed
        array.put(pressed, color)
    }

    fun enable(color: Int) {
        val pressed = android.R.attr.state_enabled
        array.put(pressed, color)
    }

    fun unable(color: Int) {
        val unable = -android.R.attr.state_enabled
        array.put(unable, color)
    }


    fun selected(color: Int) {
        val selected = android.R.attr.state_selected
        array.put(selected, color)
    }

    fun checked(color: Int) {
        val checked = android.R.attr.state_checked
        array.put(checked, color)
    }

    fun checkable(color: Int) {
        val checkable = android.R.attr.state_checkable
        array.put(checkable, color)
    }


    fun hovered(color: Int) {
        val hovered = android.R.attr.state_hovered
        array.put(hovered, color)
    }

    fun focused(color: Int) {
        val focused = android.R.attr.state_focused
        array.put(focused, color)
    }

    fun active(color: Int) {
        val active = android.R.attr.state_active
        array.put(active, color)
    }


    fun create(): ColorStateList {
        val size = array.size() + 1
        val color = IntArray(size)
        val colorState = arrayOfNulls<IntArray>(size)
        for (x in 0 until size) {
            if (x != size - 1) {
                colorState[x] = intArrayOf(array.keyAt(x))
                color[x] = array.valueAt(x)
            } else {
                colorState[x] = intArrayOf()
                color[x] = defaultColor
            }
        }
        return ColorStateList(colorState, color)
    }
}


