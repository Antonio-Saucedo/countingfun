import kotlin.random.Random
import com.soywiz.klock.*
import com.soywiz.korge.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import com.soywiz.korma.interpolation.*

// Will compute and return a random number between 1 and 9 inclusively
fun getNumber(guesses: MutableList<Int>): Int {
    var number = (1..9).random()
    while (number in guesses) {
        number = (1..9).random()
    }
    return number
}

//Main function of the game
suspend fun main() = Korge(width = 960, height = 600, bgcolor = Colors["#2b2b2b"]) {
    // Values for rotating the scale bar
    var minDegrees = (-1).degrees
    val maxDegrees = (+1).degrees
    // Getting images and rectangular elements into the screen
    val background = resourcesVfs["background.png"].readBitmap()
    val backgroundCharacter = resourcesVfs["backgroundCharacter.png"].readBitmap()
    val image :Image = image(background)
    val rect = solidRect(700, 20, Colors.PURPLE) {
        anchor(.5, .5)
        position(480, 360)
    }
    val rect2 = solidRect(200, 22, Colors.GREEN) {
        anchor(.5, .5)
        position(150, 366)
    }
    val rect3 = solidRect(200, 22, Colors.GREEN) {
        anchor(.5, .5)
        position(810, 355)
    }
    val image2 :Image = image(backgroundCharacter) {
        position(width / 2, height - 425)
    }
    var numImage = resourcesVfs["nine.png"].readBitmap()
    var cardImage = resourcesVfs["card9.png"].readBitmap()
    val monsterImage = resourcesVfs["littleMonster.png"].readBitmap()
    val monster1 = image(monsterImage) {
        position(800, 75)
    }
    // Values to be used for multiple game rounds
    val guesses = mutableListOf(0)
    var number = getNumber(guesses)
    // Checking correct number image is displayed in the game and placing it
    when (number) {
        1 -> {
            numImage = resourcesVfs["one.png"].readBitmap()
            cardImage = resourcesVfs["card1.png"].readBitmap()
        }
        2 -> {
            numImage = resourcesVfs["two.png"].readBitmap()
            cardImage = resourcesVfs["card2.png"].readBitmap()
        }
        3 -> {
            numImage = resourcesVfs["three.png"].readBitmap()
            cardImage = resourcesVfs["card3.png"].readBitmap()
        }
        4 -> {
            numImage = resourcesVfs["four.png"].readBitmap()
            cardImage = resourcesVfs["card4.png"].readBitmap()
        }
        5 -> {
            numImage = resourcesVfs["five.png"].readBitmap()
            cardImage = resourcesVfs["card5.png"].readBitmap()
        }
        6 -> {
            numImage = resourcesVfs["six.png"].readBitmap()
            cardImage = resourcesVfs["card6.png"].readBitmap()
        }
        7 -> {
            numImage = resourcesVfs["seven.png"].readBitmap()
            cardImage = resourcesVfs["card7.png"].readBitmap()
        }
        8 -> {
            numImage = resourcesVfs["eight.png"].readBitmap()
            cardImage = resourcesVfs["card8.png"].readBitmap()
        }
    }
    val image3 = image(numImage) {
        position(100, 270)
    }
    var image4 = image(cardImage) {
        position(-60, -70)
    }
    // Adding number to be guessed to a list so guess numbers are not repeated
    guesses.add(number)
    // Applying visuals for game initiation
    while (number > 0) {
        rect.addUpdater{
            rotation = minDegrees
        }
        var newRect2Y = rect2.y + 6
        rect2.addUpdater {
            positionY(newRect2Y)
        }
        var newRect3Y = rect3.y - 6
        rect3.addUpdater {
            positionY(newRect3Y)
        }
        minDegrees -= 1.degrees
        var newY = image3.y + 6
        image3.tween(image3::y[newY].duration(500.milliseconds))
        number--
    }
}
