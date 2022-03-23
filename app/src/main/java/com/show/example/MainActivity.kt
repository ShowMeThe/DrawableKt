package com.show.example

import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

            val drawable2 = drawable {
                shape(Shape.RECTANGLE){
                    solid(colorStaticList {
                        default(Color.BLACK)
                    })
                    padding(20f.dp.toInt(),20f.dp.toInt(),20f.dp.toInt(),20f.dp.toInt())
                }
            }

            image.background = LayerDrawable(arrayOf(drawable,drawable2))


        }


    }
}