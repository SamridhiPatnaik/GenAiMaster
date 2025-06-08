package Functions_OOPS_CoffeeShop
data class latte(val name: String, val favoriteCoffee: String?)
fun printFavoriteCoffee(latte : latte ) {
    val coffee = latte.favoriteCoffee ?: "Unknown"
    println("${latte.name}'s favorite coffee is: $coffee")
}
fun main() {
    val b1 = latte("Samridhi", "Latte")
    val b2 = latte("Simmi", null)

    printFavoriteCoffee(b1)
    printFavoriteCoffee(b2)
}

