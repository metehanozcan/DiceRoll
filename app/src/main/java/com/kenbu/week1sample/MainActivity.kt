package com.kenbu.week1sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random


//Author Metehan Özcan

class MainActivity : AppCompatActivity() {

    private lateinit var button:Button
    private lateinit var imageView_Dice : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.mybutton) // Roll button
        imageView_Dice = findViewById(R.id.imageView) //Dice imageView

        
        // button listener that calls rollDice method
        button.setOnClickListener { this

                rollDice()

            Toast.makeText(this, "Rolling...", Toast.LENGTH_SHORT).show()
        }

    }
    //this method creates random integer in range 1->6
    //it allows the image of the dice (imageView_dice) to change according to the number that comes out.
    //it then applies the spin animation to our imageView.
    private fun rollDice() {
        val animation : Animation = AnimationUtils.loadAnimation(this,R.anim.rotate) //animation rules

        val drawableResource = when(Random.nextInt(6)+1){
            1->R.drawable.ic_dice_1
            2->R.drawable.ic_dice_2
            3->R.drawable.ic_dice_3
            4->R.drawable.ic_dice_4
            5->R.drawable.ic_dice_5
            else ->R.drawable.ic_dice_6
        }
        imageView_Dice.setImageResource(drawableResource) //changes the view of Dice
        imageView_Dice.startAnimation(animation) // animates the dice 

    }


}
