package Functions_OOPS_CoffeeShop
fun prepareCoffee(type: String, sugarLevel: Int = 1) {
    println("Preparing a $type with $sugarLevel sugar")
}
fun main() {
    prepareCoffee("Cappuccino")
    prepareCoffee("Espresso", sugarLevel = 0)
}

