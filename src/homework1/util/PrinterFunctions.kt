package homework1.util

/**
 * Functions for printing different parts of information on the screen
 */
fun printWelcome() {
    println(
        """=======================================
        |${"GUESS THE NUMBER".padStart(27)}
        |=======================================
    """.trimMargin()
    )
}

fun printDifficultyMenu() {
    println(
        """=======================================
        |Please select difficulty (Choose the number indicated before the option)
        |1. - Easy(7 guesses)
        |2. - Medium(5 guesses)
        |3. - Hard(3 guesses)
        |4. - Exit
        |=======================================
    """.trimMargin()
    )
}

fun printDifficulty(difficulty: String, guesses: Int) {
    println(
        """Difficulty set to $difficulty.
        |You have $guesses guesses""".trimMargin()
    )
}

fun printGameStart() {
    println(
        """=======================================
        |The game has started. Try to guess the number between 1 and 100.
        |=======================================
    """.trimMargin()
    )
}

fun printStatus(guesses: Int) {
    println(
        """=======================================
        |You have $guesses guesses left
        |=======================================
    """.trimMargin()
    )
}

fun printZeroGuesses() {
    println(
        """=======================================
        |You have 0 guesses left
        |GAME OVER.
        |The game will restart.
        |=======================================
    """.trimMargin()
    )
}

fun printGuessHigher() {
    println(
        """=======================================
        |Your guess was higher than the number. Try again.
        |=======================================
    """.trimMargin()
    )
}

fun printGuessLower() {
    println(
        """=======================================
        |Your guess was lower than the number. Try again.
        |=======================================
    """.trimMargin()
    )
}

fun printGuessCorrect() {
    println(
        """=======================================
        |Your guess was spot on.
        |YOU WON!
        |=======================================
    """.trimMargin()
    )
}

fun printRestart() {
    println(
        """=======================================
        |Play Again?
        |1. - Yes
        |2. - No
        |=======================================
    """.trimMargin()
    )
}

fun printGoodbye() {
    println(
        """=======================================
        |${"GOODBYE".padStart(23)}
        |=======================================
    """.trimMargin()
    )
}

fun printWarning(message: String) {
    println("WARNING: $message")
}