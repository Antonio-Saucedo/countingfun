package com.example.countingfun

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun update(centerScale: TextView, leftScale: TextView, rightScale: TextView, numberImage: ImageView, raiseLower: Float, rotate: Float) {
    // Animation for adding monsters to the scale
    val lower = raiseLower - 10
    ObjectAnimator.ofFloat(centerScale, "rotation", -rotate, -(rotate - 1)).apply {
        duration = 1000
        start()
    }
    ObjectAnimator.ofFloat(leftScale, "translationY", raiseLower, lower).apply {
        duration = 1000
        start()
    }
    ObjectAnimator.ofFloat(rightScale, "translationY", -raiseLower, -lower).apply {
        duration = 1000
        start()
    }
    ObjectAnimator.ofFloat(numberImage, "translationY", raiseLower, lower).apply {
        duration = 1000
        start()
    }
}

fun dropMonster(monster: ImageView, number: Int, monsterCount: Int){
    // Monster drop/gravity movement
    var addSpace = 0
    if (number >= 5) {
        if (monsterCount > 3) {
            addSpace += 2
        }
        if (monsterCount > 5) {
            addSpace += 2
        }
        if (monsterCount > 8) {
            addSpace += 2
        }
        ObjectAnimator.ofFloat(monster, "translationY", (9-number)*10.toFloat()+10, (9-number+4+addSpace)*10.toFloat()).apply {
            duration = 1000
            start()
        }
    }
    else {
        ObjectAnimator.ofFloat(monster, "translationY", (9-number)*10.toFloat(), (9-number)*10.toFloat()+40).apply {
            duration = 1000
            start()
        }
    }
}

fun getRandom(): Int {
    // Generate random number
    return (0..10).shuffled().last()
}

fun setup(number: Int, card: ImageView, numberImage: ImageView, centerScale: TextView, leftScale: TextView, rightScale: TextView, rotate: Float, raiseLower: Float) {
    // Display the correct number and card based on randomly generated number
    when (number) {
        1 -> {
            numberImage.setImageResource(R.drawable.one)
            card.setImageResource(R.drawable.card1)
        }
        2 -> {
            numberImage.setImageResource(R.drawable.two)
            card.setImageResource(R.drawable.card2)
        }
        3 -> {
            numberImage.setImageResource(R.drawable.three)
            card.setImageResource(R.drawable.card3)
        }
        4 -> {
            numberImage.setImageResource(R.drawable.four)
            card.setImageResource(R.drawable.card4)
        }
        5 -> {
            numberImage.setImageResource(R.drawable.five)
            card.setImageResource(R.drawable.card5)
        }
        6 -> {
            numberImage.setImageResource(R.drawable.six)
            card.setImageResource(R.drawable.card6)
        }
        7 -> {
            numberImage.setImageResource(R.drawable.seven)
            card.setImageResource(R.drawable.card7)
        }
        8 -> {
            numberImage.setImageResource(R.drawable.eight)
            card.setImageResource(R.drawable.card8)
        }
    }
    centerScale.animate().rotation(-rotate).apply {
        duration = 2000
        start()
    }
    ObjectAnimator.ofFloat(leftScale, "translationY", raiseLower).apply {
        duration = 2000
        start()
    }
    ObjectAnimator.ofFloat(rightScale, "translationY", -raiseLower).apply {
        duration = 2000
        start()
    }
    ObjectAnimator.ofFloat(numberImage, "translationY", raiseLower).apply {
        duration = 2000
        start()
    }
}

fun playGame(card: ImageView, numberImage: ImageView, centerScale: TextView, leftScale: TextView, rightScale: TextView, addButton: ImageView, monster1: ImageView, monster2: ImageView, monster3: ImageView, monster4: ImageView, monster5: ImageView, monster6: ImageView, monster7: ImageView, monster8: ImageView, monster9: ImageView) {
    //Initialize game values
    var number = getRandom()
    var rotate = number.toFloat()
    var raiseLower = rotate * 10
    var monsterCount = 0

    // Setup screen
    setup(number, card, numberImage, centerScale, leftScale, rightScale, rotate, raiseLower)

    // Button functionality used for play
    addButton.setOnClickListener {
        // Add monster to scale
        if (rotate > 0) {
            monsterCount += 1
            when (monsterCount) {
                1 -> {
                    monster1.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                }
                2 -> {
                    monster2.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                }
                3 -> {
                    monster3.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                }
                4 -> {
                    monster4.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                }
                5 -> {
                    monster5.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                    dropMonster(monster5, number, monsterCount)
                }
                6 -> {
                    monster6.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                    dropMonster(monster5, number, monsterCount)
                    dropMonster(monster6, number, monsterCount)
                }
                7 -> {
                    monster7.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                    dropMonster(monster5, number, monsterCount)
                    dropMonster(monster6, number, monsterCount)
                    dropMonster(monster7, number, monsterCount)
                }
                8 -> {
                    monster8.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                    dropMonster(monster5, number, monsterCount)
                    dropMonster(monster6, number, monsterCount)
                    dropMonster(monster7, number, monsterCount)
                    dropMonster(monster8, number, monsterCount)
                }
                9 -> {
                    monster9.visibility = View.VISIBLE
                    dropMonster(monster1, number, monsterCount)
                    dropMonster(monster2, number, monsterCount)
                    dropMonster(monster3, number, monsterCount)
                    dropMonster(monster4, number, monsterCount)
                    dropMonster(monster5, number, monsterCount)
                    dropMonster(monster6, number, monsterCount)
                    dropMonster(monster7, number, monsterCount)
                    dropMonster(monster8, number, monsterCount)
                    dropMonster(monster9, number, monsterCount)
                }
            }
            update(centerScale, leftScale, rightScale, numberImage, raiseLower, rotate)
            raiseLower -= 10
            rotate -= 1
        }
        // Restart game
        if (monsterCount == number) {
            //Initialize game values
            number = getRandom()
            rotate = number.toFloat()
            raiseLower = rotate * 10
            monsterCount = 0
            monster1.visibility = View.INVISIBLE
            monster2.visibility = View.INVISIBLE
            monster3.visibility = View.INVISIBLE
            monster4.visibility = View.INVISIBLE
            monster5.visibility = View.INVISIBLE
            monster6.visibility = View.INVISIBLE
            monster7.visibility = View.INVISIBLE
            monster8.visibility = View.INVISIBLE
            monster9.visibility = View.INVISIBLE

            // Setup screen
            setup(number, card, numberImage, centerScale, leftScale, rightScale, rotate, raiseLower)
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get screen elements
        val card = findViewById<ImageView>(R.id.card)
        val numberImage = findViewById<ImageView>(R.id.number_image)
        val centerScale = findViewById<TextView>(R.id.center_scale)
        val leftScale = findViewById<TextView>(R.id.left_scale)
        val rightScale = findViewById<TextView>(R.id.right_scale)
        val addButton = findViewById<ImageView>(R.id.add)
        val monster1 = findViewById<ImageView>(R.id.monster1)
        val monster2 = findViewById<ImageView>(R.id.monster2)
        val monster3 = findViewById<ImageView>(R.id.monster3)
        val monster4 = findViewById<ImageView>(R.id.monster4)
        val monster5 = findViewById<ImageView>(R.id.monster5)
        val monster6 = findViewById<ImageView>(R.id.monster6)
        val monster7 = findViewById<ImageView>(R.id.monster7)
        val monster8 = findViewById<ImageView>(R.id.monster8)
        val monster9 = findViewById<ImageView>(R.id.monster9)

        // Play game
        playGame(card, numberImage, centerScale, leftScale, rightScale, addButton, monster1, monster2, monster3, monster4, monster5, monster6, monster7, monster8, monster9)
    }
}