package higherOrderFun_ExceptionHandling

fun operateOnList(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
    return numbers.map { operation(it) }
}
fun main() {
    val list = listOf(1, 2, 3, 4, 5)

    val squared = operateOnList(list) { it * it }
    val doubled = operateOnList(list) { it * 2 }

    println("Original: $list")
    println("Squared: $squared")
    println("Doubled: $doubled")
}
