package com.show.example

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.show.drawable.Shape
import com.show.drawable.dp
import com.show.drawable.drawable
import com.show.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {

            val drawable = drawable {
                shape(Shape.RECTANGLE){
                    solid(colorStaticList {
                        default(Color.GRAY)
                    })
                    gradient(45f,Color.CYAN,Color.BLUE)
                }
            }


            image.setImageDrawable(drawable)


        }


    }
}