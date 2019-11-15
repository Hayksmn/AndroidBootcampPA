package homework1

import kotlin.random.Random

fun main() {

    /**
     * State of the game
     * 0 - Game is not running(i.e. program will exit)
     * 1 - Game is being initialized
     * 2 - Game is running
     * 3 - Game has finished(i.e. waiting for restart response)
     */
    var state = 1

    /**
     * Variables which keep count of the following:
     * guesses -> number of guesses remaining (depends on selected difficulty)
     * number -> the randomly generated number which the player has to guess
     */
    var guesses = 0
    var number = 0

    printWelcome()
    gameLoop@ while (state in 1..3) {

        //check the state so that the game doesn't start running again in case of invalid input in the restart menu
        if (state != 3) {
            //Loop for determining difficulty before starting the game
            initLoop@ while (state == 1) {
                printDifficultyMenu()
                when (readLine()?.toIntOrNull()) {
                    null -> {
                        printWarning("Input was empty or was not a number. Please input a valid number.")
                        continue@initLoop
                    }
                    !in 1..4 -> {
                        printWarning(
                            "Input number was not one of the options listed." +
                                    " Please input a valid number."
                        )
                        continue@initLoop
                    }
                    1 -> {
                        guesses = 7
                        printDifficulty("Easy", guesses)
                    }
                    2 -> {
                        guesses = 5
                        printDifficulty("Medium", guesses)
                    }
                    3 -> {
                        guesses = 3
                        printDifficulty("Hard", guesses)
                    }
                    4 -> {
                        println("Bye")
                        state = 0
                        continue@gameLoop
                    }
                }

                //After setting the difficulty, the number is generated and initialization is complete
                number = Random.nextInt(0, 100)
                state = 2
                printGameStart()
            }

            //Checks if the player has run out of guesses
            if (guesses == 0) {
                printZeroGuesses()
                state = 1
                continue@gameLoop
            }

            printStatus(guesses)

            //Main game logic
            var guess = readLine()?.toIntOrNull()
            when {
                guess == null -> {
                    printWarning("Input was empty or was not a number. Please input a valid number for the guess.")
                    continue@gameLoop
                }
                guess !in 1..100 -> {
                    printWarning("The number you guessed is not in the defined range(0-100). Please try again.")
                    continue@gameLoop
                }
                guess > number -> {
                    println("=======================================")
                    println("Your guess was higher than the number. Try again.")
                    println("=======================================")
                    guesses--
                    continue@gameLoop
                }
                guess < number -> {
                    println("=======================================")
                    println("Your guess was lower than the number. Try again.")
                    println("=======================================")
                    guesses--
                    continue@gameLoop
                }
                guess == number -> {
                    println("=======================================")
                    println("Your guess was spot on.")
                    println("YOU WON!")
                    println("=======================================")
                    state = 3
                }
            }
        }

        printRestart()
        when (readLine()?.toIntOrNull()) {
            null -> {
                printWarning("Input was empty or was not a number. Please input a valid number for the guess.")
            }
            !in 1..2 -> {
                printWarning("Input number was not one of the options listed. Please input a valid number.")
            }
            1 -> {
                state = 1
            }
            2 -> {
                println("Bye")
                state = 0
                continue@gameLoop
            }
        }
    }
}

/**
 * Functions for printing different parts of information on the screen
 */
fun printWelcome() {
    println("=======================================")
    println("GUESS THE NUMBER".padStart(27))
    println("=======================================")
}

fun printDifficultyMenu() {
    println("=======================================")
    println("Please select difficulty(Choose the number indicated before the option)")
    println("1. - Easy(7 guesses)")
    println("2. - Medium(5 guesses)")
    println("3. - Hard(3 guesses)")
    println("4. - Exit")
    println("=======================================")
}

fun printDifficulty(difficulty: String, guesses: Int) {
    println("Difficulty set to $difficulty. You have $guesses guesses")
}

fun printGameStart() {
    println("=======================================")
    println("The game has started. Try to guess the number between 1 and 100.")
    println("=======================================")
}

fun printStatus(guesses: Int) {
    println("=======================================")
    println("You have $guesses guesses left")
    println("=======================================")
}

fun printZeroGuesses() {
    println("=======================================")
    println("You have 0 guesses left")
    println("GAME OVER.")
    println("The game will restart.")
    println("=======================================")
}

fun printRestart() {
    println("=======================================")
    println("Play Again?")
    println("1. - Yes")
    println("2. - No")
    println("=======================================")
}

fun printWarning(message: String) {
    println("WARNING: $message")
}