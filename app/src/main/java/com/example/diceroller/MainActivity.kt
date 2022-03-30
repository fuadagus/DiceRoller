package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()


        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 4
        val luckyMessage:String = when (diceRoll) {
            luckyNumber -> "You Win"
            1 -> "So sorry! You rolled a 1. Try again!"
            2 -> "Sadly, you rolled a 2. Try again!"
            3 -> "Unfortunately, you rolled a 3. Try again!"
            5 -> "Don't cry! You rolled a 5. Try again!"
            else -> "Apologies! You rolled a 6. Try again!"
        }
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else  -> R.drawable.dice_6
        }
        val luckyText: TextView = findViewById(R.id.textView)
        val diceImage: ImageView = findViewById(R.id.imageView)
        luckyText.setText(luckyMessage)
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()


    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}