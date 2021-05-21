package com.show.drawable

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable

class DrawableBuilder {

    companion object {
        val builder = DrawableBuilder()
    }

    private var shapeBuilder =  ShapeBuilder(Shape.RECTANGLE)


    fun shape(shape: Shape,config:ShapeBuilder.()->Unit) {
        shapeBuilder = ShapeBuilder(shape)
        config.invoke(shapeBuilder)
    }


    fun build(): Drawable {
      return  DrawableBuild.build(shapeBuilder)
    }

}