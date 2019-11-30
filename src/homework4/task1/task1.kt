package homework4.task1


fun main(args: Array<String>) {
    // Create forEachWord function
    "please print each word".forEachWord { word ->
        println(word)
    }

//     create toColor function
    println((-0x775FB34F).toColor())


    // create bitIsOneAtPosition
    val number = 4
    try {
        print(number.bitIsOneAtPosition(1))
        print(number.bitIsOneAtPosition(3))
    } catch (e: IndexOutOfBoundsException) {
        print(
            """Specified index is out of bounds for the following number:
            |$number: ${number.toBinary()}
        """.trimMargin()
        )
    }
}