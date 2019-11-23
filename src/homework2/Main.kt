package homework2

import homework2.entity.Tag
import homework2.entity.User

const val USER_SEARCH_PREFIX = "@"
const val TAG_SEARCH_PREFIX = "#"
const val EXIT_STRING = "exit"

val userSuggestionController: SuggestionController<User> = UserSuggestionController()
val tagSuggestionController: SuggestionController<Tag> = TagSuggestionController()
var searchResult = mutableListOf<String>()
/**
 * Variable for keeping track of what objects the user wants.
 *     0 - Searching for [User].
 *     1 - Searching for [Tag].
 */
var searchObjective = 0

fun main() {

    var isRunning = true

    println(
        """User and Tag Suggestions.
        |At any point you can type 'exit' to exit the application.
    """.trimMargin()
    )
    mainLoop@ while (isRunning) {
        if (searchResult.isEmpty()) {
            println(
                """Search for Users(with $USER_SEARCH_PREFIX) or Tags(with $TAG_SEARCH_PREFIX).
            |You can get recent searches for Users and Tags by just searching their prefixes.
            """.trimMargin()
            )
            var searchInput = readLine()
            when {
                searchInput == null || searchInput.isBlank() -> {
                    println("Empty Search. Try again")
                }
                searchInput.startsWith(USER_SEARCH_PREFIX) -> {
                    searchUsers(searchInput)
                }
                searchInput.startsWith(TAG_SEARCH_PREFIX) -> {
                    searchTags(searchInput)
                }
                searchInput == EXIT_STRING -> {
                    isRunning = false;
                }
                else -> {
                    println(
                        "No Match Found. " +
                                "Please search for " +
                                "users($USER_SEARCH_PREFIX) or " +
                                "tags($TAG_SEARCH_PREFIX)."
                    )
                }
            }
            continue@mainLoop
        }
        println("Please select one of the search results above.")
        var selectInput = readLine()
        when {
            selectInput == null -> {
                println("Input cannot be empty. Try again")
                continue@mainLoop
            }
            searchResult.contains(selectInput) -> {
                if (searchObjective == 0) {
                    getUser(selectInput)
                } else {
                    getTag(selectInput)
                }
            }
            selectInput == EXIT_STRING -> {
                isRunning = false
                continue@mainLoop
            }
            else -> {
                continue@mainLoop
            }
        }
        clearResultList()

    }
}

fun clearResultList() {
    searchResult = mutableListOf()
}

fun searchUsers(input: String) {
    searchObjective = 0
    val query: String = input.removePrefix(USER_SEARCH_PREFIX)
    if (!query.isBlank()) {
        searchResult = userSuggestionController.search(query).map { it.username }.toMutableList()
        if (searchResult.isNotEmpty()) {
            println("Search Results: $searchResult")
        } else {
            println("No Results found. Please try again.")
        }
    } else {
        searchResult = userSuggestionController.recent().toList().map { it.username }.toMutableList()
        if (searchResult.isNotEmpty()) {
            println("Recent: $searchResult")
        } else {
            println("Recent users are empty. Please search for tags to use the recent feature.")
        }
    }
}

fun getUser(input: String) {
    val user: User? = userSuggestionController.get(input)
    if (user != null) {
        println(user)
    } else {
        println("User information unavailable.")
    }
}

fun searchTags(input: String) {
    searchObjective = 1
    val query: String = input.removePrefix(TAG_SEARCH_PREFIX)
    if (!query.isBlank()) {
        searchResult = tagSuggestionController.search(query).map { it.tag }.toMutableList()
        if (searchResult.isNotEmpty()) {
            println("Search Results: $searchResult")
        } else {
            println("No Results found. Please try again.")
        }
    } else {
        searchResult = tagSuggestionController.recent().toList().map { it.tag }.toMutableList()
        if (searchResult.isNotEmpty()) {
            println("Recent: $searchResult")
        } else {
            println("Recent tags are empty. Please search for tags to use the recent feature.")
        }
    }
}

fun getTag(input: String) {
    val tag: Tag? = tagSuggestionController.get(input)
    if (tag != null) {
        println(tag)
    } else {
        println("Tag information unavailable.")
    }
}