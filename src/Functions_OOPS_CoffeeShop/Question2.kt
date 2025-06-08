package Functions_OOPS_CoffeeShop
fun calculatePrice(quantity: Int, pricePerCup: Double?): Double {
    val price = pricePerCup ?:0.0
    return quantity * price
}
fun main() {
    val total1 = calculatePrice(3, 4.5)
    val total2 = calculatePrice(2, null)
    println("Total 1: $total1")
    println("Total 2: $total2")
}

