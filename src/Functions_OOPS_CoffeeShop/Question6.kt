package Functions_OOPS_CoffeeShop
fun getHighestPrice(prices: List<Double>): Double? {
    return prices.maxOrNull()
}
fun main() {
    val coffeePrices = listOf(220.0, 180.0, 200.0, 350.00)
    val highest = getHighestPrice(coffeePrices)
    println("Highest Price: $highest")
}
