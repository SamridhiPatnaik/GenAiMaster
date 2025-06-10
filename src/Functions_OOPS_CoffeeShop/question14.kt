package Functions_OOPS_CoffeeShop

fun Discount(prices: List<Double>): List<Double> {
    return prices.map { it * 0.9 }
}
fun main() {
    val originalPrices = listOf(3.0, 4.5, 5.0, 2.75)
    val discountedPrices = Discount(originalPrices)

    println("Original Prices: $originalPrices")
    println("Discounted Prices: $discountedPrices")
}

