package higherOrderFun_ExceptionHandling

fun main() {
    val input = "abc"
    try {
        val number = input.toInt()
        println("Converted number: $number")
    } catch (e: NumberFormatException) {
        println("Error: '$input' is not a valid number.")
    }
}
