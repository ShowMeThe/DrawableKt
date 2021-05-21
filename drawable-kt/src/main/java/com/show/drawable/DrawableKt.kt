package com.show.drawable

import android.graphics.drawable.Drawable


fun drawable(config: DrawableBuilder.() -> Unit): Drawable {
    val builder = DrawableBuilder.builder
    config.invoke(builder)
    return builder.build()
}

