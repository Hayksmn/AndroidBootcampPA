package homework3


fun main(args: Array<String>) {
    val user1: User? = User("A", null)
    val user2 = User("B", user1)
//    user1?.parent = user2
//    user2.parent?.name
    user2.parent?.name


}

class User(val name: String, parent: User?) {
    var parent by weak(parent)

    override fun toString(): String {
        return name
    }
}
