package higherOrderFun_ExceptionHandling
fun main() {
    val num = listOf(1, 2, 3, 4, 5, 6)
    val evenNumbers = num.filter { it % 2 == 0 }
    println("Even numbers are: $evenNumbers")
}