package homework1.util

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

fun printGuessHigher() {
    println("=======================================")
    println("Your guess was higher than the number. Try again.")
    println("=======================================")
}

fun printGuessLower() {
    println("=======================================")
    println("Your guess was lower than the number. Try again.")
    println("=======================================")
}

fun printGuessCorrect() {
    println("=======================================")
    println("Your guess was spot on.")
    println("YOU WON!")
    println("=======================================")
}

fun printRestart() {
    println("=======================================")
    println("Play Again?")
    println("1. - Yes")
    println("2. - No")
    println("=======================================")
}

fun printGoodbye() {
    println("=======================================")
    println("GOODBYE".padStart(23))
    println("=======================================")
}

fun printWarning(message: String) {
    println("WARNING: $message")
}