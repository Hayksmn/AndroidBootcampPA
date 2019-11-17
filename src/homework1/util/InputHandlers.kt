package homework1.util

/**
 * Function for handling initialization prompt input(i.e. setting the difficulty for the game).
 * @return Returns -1 if there is an input error,
 *         7, 5, 3 depending on the difficulty selected,
 *         -2 if player wants to exit the game.
 */
fun getInitInput(): Int {
    printDifficultyMenu()
    return when (readLine()?.toIntOrNull()) {
        null -> {
            printWarning(
                """Input was either empty, too small, too big, or was not a number.
                |Please input a valid number for the guess.""".trimMargin()
            )
            -1
        }
        !in 1..4 -> {
            printWarning(
                """Input number was not one of the options listed.
                |Please input a valid number.""".trimMargin()
            )
            -1
        }
        1 -> {
            printDifficulty("Easy", 7)
            7
        }
        2 -> {
            printDifficulty("Medium", 5)
            5
        }
        3 -> {
            printDifficulty("Hard", 3)
            3
        }
        else -> -2
    }
}

/**
 * Function for handling restart prompt input
 * and returning a state value accordingly.
 * @param state The current state value of the game.
 * @return Returns unchanged value of state if there is an input error,
 *         1 if the user wants to restart the game,
 *         0 if the user wants to exit the game.
 */
fun getRestartInput(state: Int): Int {
    printRestart()
    return when (readLine()?.toIntOrNull()) {
        null -> {
            printWarning(
                """Input was either empty, too small, too big, or was not a number.
                |Please input a valid number for the guess.""".trimMargin()
            )
            state
        }
        !in 1..2 -> {
            printWarning(
                """Input number was not one of the options listed.
                |Please input a valid number.""".trimMargin()
            )
            state
        }
        1 -> 1
        else -> {
            printGoodbye()
            0
        }
    }
}

/**
 * Function for handling guessing input
 * @param number The randomly generated number that the user needs to guess.
 * @return Returns -1 if there is an input error,
 *         -2 if the user guessed incorrectly,
 *         0 if the guess was correct.
 */
fun getGuessInput(number: Int): Int {
    val guess = readLine()?.toIntOrNull()

    return when {
        guess == null -> {
            printWarning(
                """Input was either empty, too small, too big, or was not a number.
                |Please input a valid number for the guess.""".trimMargin()
            )
            -1
        }
        guess !in 1..100 -> {
            printWarning(
                """The number you guessed is not in the defined range(1-100).
                |Please try again.""".trimMargin()
            )
            -1
        }
        guess > number -> {
            printGuessHigher()
            -2
        }
        guess < number -> {
            printGuessLower()
            -2
        }
        else -> {
            printGuessCorrect()
            0
        }
    }
}