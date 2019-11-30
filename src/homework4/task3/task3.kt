package homework4.task3


infix fun IntArray.add(int: Int): IntArray {
    val array = this.copyOf(this.size + 1)
    array[array.lastIndex] = int
    return array
}

infix fun IntArray.insert(value: Int): IntArray {
    return this.add(value)
}

infix fun IntArray.at(index: Int): IntArray {
    val array = this.copyOf(this.size)
    array[index] = array[array.lastIndex]
    return array.dropLast(1).toIntArray()
}

infix fun IntArray.`remove at`(index: Int): IntArray {
    val array = this.copyOf(this.size)
    array[index] = 0
    return array
}

infix fun IntArray.print(range: IntRange) {
    for (i in range) {
        print("${this[i]} ")
    }
}

object size

infix fun IntArray.get(int: size): Int = this.size

object all

infix fun IntArray.print(obj: all) {
    this.forEach { print("$it ") }
}

fun main(args: Array<String>) {
    var arr = IntArray(0)
    arr = arr add 3 // create new array and add element at the end
    arr = arr add 7 add 1
    arr = arr add 9 add 6 add 8
    arr = arr insert 5 at 2 // insert 5 into position 2
    arr = arr `remove at` 3 // set to 0 at position 3
    arr = arr `remove at` 1
    arr print 2..5 // 5 0 6 8

    // optional
    println()
    println(arr get size) // 6
    arr print all // 3 0 5 0 6 8
}
