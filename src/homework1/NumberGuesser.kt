package homework1

import kotlin.random.Random

fun main() {
    //Flags for init and game loops
    var isRunning: Boolean = true
    var isInitializing: Boolean = true

    //Flag for game restart
    var isFinished: Boolean = false


    //Variables for game
    var difficulty: Int?
    var guesses: Int = 0
    var number: Int = 0

    printWelcome()
    gameLoop@ while (isRunning) {
        if (!isFinished) {
            //Loop for determining difficulty before starting the game
            initLoop@ while (isInitializing) {
                printDifficultyMenu()
                difficulty = readLine()?.toIntOrNull()
                if (difficulty != null) {
                    when (difficulty) {
                        1 -> {
                            println("Difficulty set to Easy. You have 7 guesses")
                            guesses = 7
                        }
                        2 -> {
                            println("Difficulty set to Medium. You have 5 guesses")
                            guesses = 5
                        }
                        3 -> {
                            println("Difficulty set to Hard. You have 4 guesses")
                            guesses = 3
                        }
                        4 -> {
                            println("Bye")
                            break@gameLoop
                        }
                        else -> {
                            printWarning("Input number was not one of the options listed. Please input a valid number.")
                            continue@initLoop
                        }
                    }
                    /**
                     * After setting difficulty number is generated and initialization is complete
                     * the game loop can begin to execute
                     */
                    number = Random.nextInt(0, 100)
                    isInitializing = false
                    printGameStart()
                    println(number)
                } else {
                    //Input was empty or was not a number so loop starts again
                    printWarning("Input was empty or was not a number. Please input a valid number.")
                }
            }

            if (guesses == 0) {
                printZeroGuesses()
                isInitializing = true;
                continue@gameLoop
            }
            printStatus(guesses)
            var guess: Int? = readLine()?.toIntOrNull()
            if (guess != null) {
                if (guess in 0..100) {
                    when {
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
                        else -> {
                            println("=======================================")
                            println("Your guess was spot on.")
                            println("YOU HAVE WON!")
                            println("=======================================")
                            isFinished = true
                        }
                    }
                } else {
                    printWarning("The number you guessed is not in the defined range(0-100). Please try again.")
                    continue@gameLoop
                }
            } else {
                printWarning("Input was empty or was not a number. Please input a valid number for the guess.")
                continue@gameLoop
            }
        }

        println("=======================================")
        println("Play Again?")
        println("1. - Yes")
        println("2. - No")
        println("=======================================")
        var restart: Int? = readLine()?.toIntOrNull()
        if (restart != null) {
            when (restart) {
                1 -> {
                    isInitializing = true
                    isFinished = false
                }
                2 -> {
                    println("Bye")
                    break@gameLoop
                }
                else -> {
                    printWarning("Input number was not one of the options listed. Please input a valid number.")
                }
            }
        } else {
            printWarning("Input was empty or was not a number. Please input a valid number for the guess.")
        }
    }
}

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

fun printGameStart() {
    println("=======================================")
    println("The game has started. Try to guess the number between 0 and 100.")
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

fun printWarning(message: String) {
    println("WARNING: $message")
}