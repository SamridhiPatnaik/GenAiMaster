package higherOrderFun_ExceptionHandling

fun main() {
    val coffees = listOf("Latte", "Espresso", "Mocha")
    val upperCoffees = coffees.map { it.uppercase() }
    println("Mapped (uppercased) list: $upperCoffees")
    println("Original list printed using forEach():")
    coffees.forEach { println(it) }
}
