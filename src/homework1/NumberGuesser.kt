package homework1

import kotlin.random.Random
import homework1.util.*

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
                        printGoodbye()
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
                    printGuessHigher()
                    guesses--
                    continue@gameLoop
                }
                guess < number -> {
                    printGuessLower()
                    guesses--
                    continue@gameLoop
                }
                guess == number -> {
                    printGuessCorrect()
                    state = 3
                }
            }
        }

        printRestart()
        when (readLine()?.toIntOrNull()) {
            null -> printWarning("Input was empty or was not a number. Please input a valid number for the guess.")
            !in 1..2 -> printWarning("Input number was not one of the options listed. Please input a valid number.")
            1 -> state = 1
            2 -> {
                printGoodbye()
                state = 0
            }
        }
    }
}