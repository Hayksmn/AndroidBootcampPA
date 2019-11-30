package homework4.task2

class Node(
    val name: String
) {
    val nodes = mutableListOf<Node>()

    override fun toString(): String {
        return "Name: $name"
    }
}

fun Node.node(name: String, init: Node.() -> Unit = {}): Node {
    val node: Node = Node(name)
    node.init()
    this.nodes.add(node)
    return node
}

fun root(init: Node.() -> Unit){
    val node: Node = Node("root")
    node.init()
}

// create root and node
fun main(args: Array<String>) {
    root {
        node("1") {
            node("3") {
                node("5")
            }
            node("4")
        }
        node("2")
    }
}