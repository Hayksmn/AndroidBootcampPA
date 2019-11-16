package homework1.util


fun initInput(): Int {
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

fun restartInput(state: Int): Int {
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

fun guessInput(number: Int): Int {
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