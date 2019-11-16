package homework1

import homework1.util.*
import kotlin.random.Random

fun main() {
    /**
     * State of the game
     * 0 - Game is not running(i.e. program will exit)
     * 1 - Game is being initialized
     * 2 - Game is running
     * 3 - Game is complete. Waiting for restart response
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
        when (state) {
            1 -> {
                //Initializing the game
                guesses = initInput()
                if (guesses == -1) continue@gameLoop
                else if (guesses == -2) {
                    printGoodbye()
                    state = 0
                    continue@gameLoop
                }
                //After setting the difficulty, the number is generated and state is updated
                number = Random.nextInt(0, 100)
                state = 2
                printGameStart()
            }
            2 -> {
                //Checks if the player has run out of guesses
                if (guesses == 0) {
                    printZeroGuesses()
                    state = 1
                    continue@gameLoop
                }
                printStatus(guesses)
                //Main game logic
                val guess = guessInput(number)
                if (guess == -1) continue@gameLoop
                else if (guess == -2) {
                    guesses--
                    continue@gameLoop
                }
                state = 3
            }
            3 -> state = restartInput(state)  //Prompt for restarting or quitting the game
        }
    }
}