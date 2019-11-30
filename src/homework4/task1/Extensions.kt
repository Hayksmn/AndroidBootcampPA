package homework4.task1

import java.lang.IndexOutOfBoundsException

fun String.forEachWord(forEach: (word: String) -> Unit) {
    for (word: String in this.split(" ")) {
        forEach(word)
    }
}

fun Int.toColor(): Color {
    return Color(
        this shr 24 and 0xff,
        this shr 16 and 0xff,
        this shr 8 and 0xff,
        this and 0xff
    )
}


const val BINARY_TRUE: Char = '1'
const val BINARY_FALSE: Char = '0'

//NOTE index starts at 1
@Throws(IndexOutOfBoundsException::class)
fun Int.bitIsOneAtPosition(index: Int): Boolean {
    /*Using toString with radix 2(i.e. base 2 system)
    * works with positive numbers only.
    * */
//    return this.toString(2)[index - 1] == BINARY_TRUE
    /*
    * Java Integer class does the same but
    * handles negative numbers as well.
    * */
    return Integer.toBinaryString(this)[index - 1] == BINARY_TRUE
}

fun Int.toBinary(): String{
    return Integer.toBinaryString(this)
}
