package Functions_OOPS_CoffeeShop
fun filterCoffeeStartingWithC(coffeeList: List<String>): List<String> {
    return coffeeList.filter { it.startsWith("C", ignoreCase = true) }
}
fun main() {
    val coffees = listOf("Latte", "Cappuccino", "Espresso", "Cold Brew")
    val filtered = filterCoffeeStartingWithC(coffees)
    println("Coffees starting with 'C': $filtered")
}

